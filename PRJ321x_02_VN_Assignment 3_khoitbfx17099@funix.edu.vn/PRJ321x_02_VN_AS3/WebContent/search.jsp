<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<c:import url="header.jsp" />

<div class="content">
			
			<h2 style="text-align: center; margin: 178px 20px 200px 20px;">${message }</h2>
	
	
	<div class="product-aria">
	
	
		<div class="row">
			<c:forEach var="product" items="${producList}">
				<div class="col">
					<div class="product-box">
						<div class="imge-box">
							<a href="infoProductController?id=${product.id}"><img src="${product.src}" alt="" class="product-img" /></a>
						</div>
						<div class="des-text">
							<h2>${product.type}</h2>
							<h3>${product.name}</h3>
							
						</div>
						<div class="price-box">
							<span class="price">${product.price} $</span>
							<div class="cart-btn">
							<a href="AddToCartController?id=${product.id}&action=add" class=""><i class="bi bi-cart-plus-fill"></i></a>
							</div>
							
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	
	</div>

	

</div>

<c:import url="footer.jsp"></c:import>
