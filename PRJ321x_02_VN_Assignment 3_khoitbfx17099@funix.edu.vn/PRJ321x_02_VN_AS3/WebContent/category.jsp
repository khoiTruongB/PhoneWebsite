
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<c:import url="header.jsp" />
<%



%>
<div class="content">
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

	<!-- start page -->
	<div class="page">
		<ul>
			<c:choose>
				<c:when test="${i==1}">
					<li style="display: none"><a href="CategoryContoller?page=${i-1}"><i
							class="bi bi-chevron-double-left"></i></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="CategoryContoller?page=${i-1}&type=${type}"><i
							class="bi bi-chevron-double-left"></i></a></li>
				</c:otherwise>
			</c:choose>

			<!-- page list -->
			<c:forEach var="i" begin="1" end="${page}">
				<li><a href="CategoryContoller?page=${i}&type=${type}">${i}</a></li>
			</c:forEach>
			<!-- page list -->

			<c:choose>
				<c:when test="${i==page}">
					<li style="display: none"><a href="CategoryContoller?page=${i+1}">
							<i class="bi bi-chevron-double-right"></i>
					</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="CategoryContoller?page=${i+1}&type=${type}"> <i
							class="bi bi-chevron-double-right"></i>
					</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
	<!-- start page -->

</div>

<c:import url="footer.jsp"></c:import>
