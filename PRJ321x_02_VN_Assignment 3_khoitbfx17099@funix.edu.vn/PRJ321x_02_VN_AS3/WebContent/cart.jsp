
<%@page import="controller.productPage"%>
<%@page import="model.*, java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="header.jsp" />


<%
Cart c = (Cart) session.getAttribute("cart");
List<Product> pl = c.getItems();
int size = pl.size();
int amont = 0;
String d;
pageContext.setAttribute("pl", pl);
%>


<div class="content">
	<div>
		<i class="bi bi-arrow-left"></i> <a href="productPage">${buy}</a>
	</div>
	<div class="cart-aria">
		<c:if test="${pl==null }">
			<table
				style="width: 100%; border-collapse: collapse; border-spacing: 0;">
				<thead>
					<td>Products in cart:</td>
					<td>Image</td>
					<td>Price</td>
					<td>Quantily</td>
					<td colspan="2">Amount</td>
				</thead>


				<tr>
					<td>
						<p></p>
						<p></p>
					</td>

					<td style="width: 150px; height: 150px;"><img
						style="width: 90%" alt="" src=""></td>

					<td>($)</td>
					<td></td>
					<td>($)</td>

					<td style="text-align: center;"></td>
				</tr>


				<tr>
					<td colspan="6" class="left">Total:</td>
				</tr>
			</table>
		</c:if>

		<c:if test="${pl!=null }">
			<table
				style="width: 100%; border-collapse: collapse; border-spacing: 0;">
				<thead>
					<td>Products in cart: <%=size%></td>
					<td>Image</td>
					<td>Price</td>
					<td>Quantily</td>
					<td colspan="2">Amount</td>
				</thead>

				<c:forEach var="pro" items="${pl}">
					<tr>
						<td>
							<p>${pro.name }</p>
							<p>ID: ${pro.id }</p>
						</td>

						<td style="width: 150px; height: 150px;"><img
							style="width: 90%" alt="" src="${pro.src }"></td>

						<td>($) ${pro.price }</td>
						<td>
							<button class="plus-btn">
								<a href="AddToCartController?id=${pro.id}&action=minus"><b>-</b></a>
							</button> <input class="number-input" type="text" value="${pro.number }" />

							<button class="plus-btn">
								<a href="AddToCartController?id=${pro.id}&action=add"><b>+</b></a>
							</button>
						</td>
						<td>($) <fmt:formatNumber value="${pro.number * pro.price}"
								type="number" maxFractionDigits="2" /></td>

						<td style="text-align: center;">
							<button class="remo-btn">
								<a href="AddToCartController?id=${pro.id }&action=delete">remove</a>
							</button>
						</td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="6" class="left">Total: <%=c.getTotal()%></td>
				</tr>
			</table>
		</c:if>

	</div>
	<form action="PayController" method="get">
		<div class="customer-ifo">
			<div class="table-left">
				<table>
					<tr>
						<td>Customer name</td>
					</tr>
					<tr>
						<td>Customer address</td>
					</tr>
					<tr>
						<td>Discount code(if any)</td>
					</tr>
				</table>
				<div style="margin-top: 20px">

					<input type="submit" class="btn-add" value="Submit" />

					<!--  <a class="btn-add" href="PayController">Submit</a>-->
				</div>


			</div>

			<c:if test="${user==null}">
				<div class="table-right">
					<table>
						<tr>
							<td><input type="text" /></td>
						</tr>
						<tr>
							<td><input type="text" /></td>
						</tr>
						<tr>
							<td><input type="text" /></td>
						</tr>
					</table>
				</div>
			</c:if>

			<c:if test="${user!=null}">
				<div class="table-right">
					<table>
						<tr>
							<td>${user.name}</td>
						</tr>
						<tr>
							<td>${user.address}</td>
						</tr>
						<tr>

							<td><input type="text" name="Discount" /></td>
						</tr>
					</table>
				</div>
			</c:if>

		</div>
	</form>
</div>

<c:import url="footer.jsp"></c:import>
