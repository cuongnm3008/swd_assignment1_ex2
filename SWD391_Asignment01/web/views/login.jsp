<%-- 
    Document   : login.jsp
    Created on : Jan 19, 2022, 12:05:35 AM
    Author     : Nguyen Manh Cuong
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
           <%@include file="components/header.jsp" %>
    </head>
    <body>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form action="login" method="post">
                           <h2>Login Form</h2>
                           <c:if test="${not empty message}">
                                <span class="text-danger">${message}</span>
                           </c:if>
                            <div class="form-group">
                                <label>UserName</label> 
                                <input type="text"class="form-control"name="username" required="required">
                            </div>
                            <div class="form-group">
                                <label>Password</label> 
                                <input type="password"class="form-control"name="password" required="required">
                            </div>
                            <button type="submit" class="btn btn-success">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

