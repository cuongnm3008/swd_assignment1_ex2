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
                    <form action="authorize_payment" method="post">
                           <h2>Check out</h2>
                            <div class="form-group">
                                <label>Book Name</label> <input type="text"
                                    value="<c:out value='${MODEL.productName}' />" class="form-control"
                                    name="productName" readonly>
                            </div>
                            <div class="form-group">
                                <label>Quantity</label> <input type="text"
                                value="<c:out value='${MODEL.quantity}' />" class="form-control"
                                 name="quantity" readonly>
                            </div>
                            <div class="form-group">
                                <label>Sub Total ($)</label> <input type="text"
                                value="<c:out value='${MODEL.subtotal}' />" class="form-control"
                                 name="subtotal" readonly>
                            </div>
                            <div class="form-group">
                                <label>Shipping ($)</label> <input type="text"
                                value="<c:out value='${MODEL.shipping}' />" class="form-control"
                                 name="shipping" readonly>
                            </div>
                                  <div class="form-group">
                                <label>Tax ($)</label> <input type="text"
                                value="<c:out value='${MODEL.tax}' />" class="form-control"
                                 name="tax" readonly>
                            </div>
                                <div class="form-group">
                                <label>Total Amount ($)</label> <input type="text"
                                value="<c:out value='${MODEL.totalPrice}' />" class="form-control"
                                name="totalPrice" readonly>
                            </div>  
                                <center>
                                    <button type="submit" class="btn btn-success">Check out</button>
                                </center>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
