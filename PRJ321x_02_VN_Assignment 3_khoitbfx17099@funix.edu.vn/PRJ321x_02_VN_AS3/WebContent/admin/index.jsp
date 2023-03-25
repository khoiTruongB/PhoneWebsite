<%@page import="java.util.List"%>
<%@page import="dao.ListUserDAO"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./css/admin.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
    <title>Document</title>



    
  </head>
  <body>
    <div class="content">
      <div class="left-colum">
        <h2>1111 TEAM</h2>
        <div class="menu-board">
          <ul>
            <li>
              <a href=""><i class="bi bi-grid-fill ml"></i> Dashboard</a>
            </li>
            <li>
              <a href=""><i class="bi bi-person-fill ml"></i> Staff Manager</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="right-colum">
        <div class="login-header">
          <i class="bi bi-grid-fill ml"></i>
          <i class="bi bi-person-fill ml"></i>
          <button class="btn-logout">Logout</button>
        </div>
        <div class="header-img">
          <img src="./image/header.jpg" alt="" />
        </div>
        <div class="title-table">
          <h3>Member of the team</h3>
        </div>
        <div class="member-table">
          <table>
            <thead style="height: 40px"></thead>
            <thead>
              <tr>
                <th>Mail</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="u" items="${user }">
            
             <tr>
                <td>${u.mail }</td>
                <td>${u.name}</td>
                <td>${u.address}</td>
                <td>${u.phone}</td>
              </tr>
            
            </c:forEach>
              
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </body>
</html>
