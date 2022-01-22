<%-- 
    Document   : register
    Created on : Jan 19, 2022, 12:06:34 AM
    Author     : Nguyen Manh Cuong
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Register</title>
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
                    <form action="insert-book" method="post">
                           <h2>Register Form</h2>
                            <div class="form-group">
                                <label>UserName</label> <input type="text"
                                    value="<c:out value='${book.title}' />" class="form-control"
                                    name="title" required="required">
                            </div>
                            <div class="form-group">
                                <label>Password</label> <input type="text"
                                value="<c:out value='${book.author}' />" class="form-control"
                                 name="author">
                            </div>
                            <div class="form-group">
                                <label>Full Name</label> <input type="text"
                                value="<c:out value='${book.author}' />" class="form-control"
                                 name="author">
                            </div>
                                 <div class="form-group">
                                <label>Phone</label> <input type="text"
                                value="<c:out value='${book.author}' />" class="form-control"
                                 name="author">
                            </div>
                            <button type="submit" class="btn btn-success">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
