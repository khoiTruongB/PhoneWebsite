<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.*, java.util.*, dao.*"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />

<title>Document</title>
</head>
<%
ListProductDAO dao = new ListProductDAO();
List<Product> Category = dao.productCategory();
pageContext.setAttribute("Category", Category);
%>
<body>
	<!-- start header -->
	<div class="header">
		<div class="top-header">
			<div class="logo-aria">
				<h1>PRJ321x</h1>
				<h3>Welcome to my Website</h3>
			</div>
			<div class="search-aria">
				<div class="dropdown">
					<div class="dropdown-select">
						<span class="dropdown-selected">Categories</span> <i
							class="bi bi-chevron-expand"></i>
					</div>
					<ul class="drop-list">
						<c:forEach var="categry" items="${Category}">
							<li class="drop-item"><a href="CategoryContoller?type=${categry.brand}" class="dropdown-selected">${categry.brand}</a>
							</li>
						</c:forEach>

					</ul>
				</div>
				<form style="display: contents;" action="SearchController2" method="post">
						
					<input type="search"  name="search" id="" class="search-box" placeholder="what are you locoking for?"/>
					<div class="search-button">
						<h2>
							<i class="bi bi-search"></i>
						</h2>
						<input type="submit" class="search-btn" value="">

					</div>

				</form>
			</div>
		</div>

		<!-- start navbar -->
		<div class="navbar">
			<div class="nav-menu">
				<ul>
					<li><a href="productPage">Home</a></li>
					<li><a href="productPage">Product</a></li>
					<li><a href="aboutus.jsp">About us</a></li>
				</ul>
			</div>
			<div class="login-aria" style="display: flex;">

				<c:if test="${user==null }">

					<c:choose>
						<c:when test="${cart.size==null}">
							<a href="AddToCartController?action=add" class="btn-login"> <i
								class="bi bi-cart3"></i> (<b style="color: red;">0</b>)
							</a>
						</c:when>
						<c:otherwise>
							<a href="AddToCartController" class="btn-login"> <i
								class="bi bi-cart3"></i> (<b style="color: red;">${cart.size}</b>)
							</a>
						</c:otherwise>
					</c:choose>

					<a href="login.jsp" class="btn-login" id="btn-login">Login</a>
					<a href="register.jsp" class="btn-login" id="btn-login">Register</a>

				</c:if>

				<c:if test="${user!=null }">
					
					<c:if test="${user.role==0 }">
					<span class="btn-login"><i class="bi bi-file-person"></i>${user.name}</span>
					</c:if>
					<c:if test="${user.role==1 }">
					<a href="UserController" class="btn-login">Admin page</a>
					<span class="btn-login"><i class="bi bi-file-person"></i>Admin: ${user.name}</span>
					</c:if>
					

					<c:choose>
						<c:when test="${cart.size==null}">
							<a href="AddToCartController?action=add" class="btn-login"> <i
								class="bi bi-cart3"></i> (<b style="color: red;">0</b>)
							</a>
						</c:when>
						<c:otherwise>
							<a href="AddToCartController" class="btn-login"> <i
								class="bi bi-cart3"></i> (<b style="color: red;">${cart.size}</b>)
							</a>
						</c:otherwise>
					</c:choose>


					<form action="LogoutController" method="post">
						<input style="background: none; border: navy;" type="submit"
							class="btn-login" value="Logout">
					</form>

				</c:if>

			</div>
		</div>
		<!-- end navbar -->
	</div>