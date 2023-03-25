<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="controller.productPage"%>
<%@page import="model.*, java.util.*"%>

<%
Cart c = (Cart) session.getAttribute("cart");
 
List<Product> pl = c.getItems();
pageContext.setAttribute("pl", pl);
%>
<head>
<link rel="stylesheet" href="./css/pay.css" />
</head>
<c:import url="header.jsp" />

<div class="bg-light">
	<div class="container" style="font-size: 18px; margin: 30px 0px;">

		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted" style="font-size: 20px">Your cart</span> <span
						class="badge badge-secondary badge-pill">${cart.size}</span>
				</h4>
				<ul class="list-group mb-3">

					<c:forEach var="list" items="${pl }">
						<li
							class="list-group-item d-flex justify-content-between lh-condensed">
							<div>
								<h6 class="my-0">Product name</h6>
								<small class="text-muted">${list.name } x (${list.number })</small>
							</div> <span class="text-muted"> <fmt:formatNumber
									value="${list.number * list.price}" type="number"
									maxFractionDigits="2" />
						</span>
						</li>
					</c:forEach>

					<li class="list-group-item d-flex justify-content-between"><span>Total
							(USD)</span> <strong><%=c.getTotal()%></strong></li>
				</ul>
			</div>

			<div class="col-md-8 order-md-1">
				<h4 class="mb-3" style="font-style: 20px">Billing address</h4>
				<form class="needs-validation" action="PayController" method="post">
				
					
						<div class="mb-3">
							<label for="username">Username</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">@</span>
								</div>
								<input type="text" class="form-control" id="username" name="username"
									value="${user.name }" required>
								<div class="invalid-feedback" style="width: 100%;">Your
									username is required.</div>
							</div>
						</div>

						<div class="mb-3">
							<label for="email">Email <span class="text-muted">(Optional)</span></label>
							<input type="email" class="form-control" id="email" name="email"
								value="${user.mail}">
							<div class="invalid-feedback">Please enter a valid email
								address for shipping updates.</div>
						</div>

						<div class="mb-3">
							<label for="address">Address</label> <input type="text"
								class="form-control" id="address" name="address" value="${user.address }"
								required>
							<div class="invalid-feedback">Please enter your shipping
								address.</div>
						</div>
						
						<div class="mb-3">
							<label for="address">Discount</label> <input type="text"
								class="form-control" id="discount" name="discount"
								value="<%=session.getAttribute("Discount")%>">
						</div>

					<button class="btn btn-primary btn-lg btn-block" type="submit">Continue
						to checkout</button>
				</form>
			</div>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script
		src="https://getbootstrap.com/docs/4.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
	<script
		src="https://getbootstrap.com/docs/4.3/examples/checkout/form-validation.js"></script>
</div>
<c:import url="footer.jsp" />
</html>