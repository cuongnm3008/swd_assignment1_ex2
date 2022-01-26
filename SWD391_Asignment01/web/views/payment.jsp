<%-- 
    Document   : payment
    Created on : Jan 24, 2022, 9:26:44 PM
    Author     : THEND
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Payment</title>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="views/assets/css/alpha.min.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/custom.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/jquery.dataTables.min.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/materialize.min.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/bootstrap.min"></c:url>">
            <link rel="stylesheet"
                  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                  crossorigin="anonymous">
        <%@include file="components/header.jsp" %>
    </head>
    <body>
        <div class="container d-lg-flex">
            <div class="container mt-2 card" style="width: 70%;">
                <div class="col-md-12">
                    <div class="box-inner-2 ">
                        <div>
                            <p class="fw-bold h2">PAYMENT DETAILS</p>
                            <p class="dis mb-3">Complete your purchase by providing your payment details</p>
                        </div>
                        <form action="<%=request.getContextPath()%>/checkout" method="get">
                            <div class="mb-3">
                                <p class="dis fw-bold mb-2">Book Name</p> <input class="form-control" type="text" name="bookname" value="${bookname}" readonly>
                            </div>
                            <div class="mb-3">
                                <p class="dis fw-bold mb-2">Quantity</p> <input class="form-control" type="text" name="quantity" value="${quantity}" readonly>
                            </div>
                            <div class="mb-3">
                                <p class="dis fw-bold mb-2">Address</p> <input class="form-control" type="text" name="address" value="">
                            </div>
                            <div>
                                <div class="my-3 cardname p-2">
                                    <p class="dis fw-bold mb-2">Payment methods</p>
                                    <p><input type="radio" name="dish" value="receiving">   Pay after receiving the book</input></p>
                                    <p><input type="radio" name="dish" value="Card">    Pay by credit card</input></p>
                                </div>
                            </div>
                            <div>
                                <div class=" my-3">
                                    <p class="dis fw-bold mb-2">VAT Number</p>
                                    <div class="inputWithcheck"> <input class="form-control" type="text" value="GB012345B9" readonly> <span class="fas fa-check"></span> </div>
                                </div>
                                <div class="d-flex flex-column dis">
                                    <div class="d-flex align-items-center justify-content-between mb-2">
                                        <p>Sub Total ($)</p>
                                        <p><span class="fas fa-dollar-sign"></span>${subtotal}</p>
                                        <input type="hidden" name="subtotal" value="${subtotal}">
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mb-2">
                                        <p>Shipping ($)<span></span></p>
                                        <p><span class="fas fa-dollar-sign"></span>10</p>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mb-2">
                                        <p>VAT<span>(10%)</span></p>
                                        <p><span class="fas fa-dollar-sign"></span>${VAT}</p>
                                        <input type="hidden" name="VAT" value="${VAT}">
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mb-2">
                                        <p class="fw-bold">Total ($)</p>
                                        <p class="fw-bold"><span class="fas fa-dollar-sign"></span>${totalPrice}</p>
                                        <input type="hidden" name="totalPrice" value="${totalPrice}">
                                    </div>
                                    <button type="submit" class="btn" style="background-color:#3A954E; color: wheat">
                                        Pay ${totalPrice}
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src=" <c:url value="views/assets/js/alpha.min.js"></c:url>" type="text/javascript"></script>
        <script src=" <c:url value="views/assets/js/jquery-2.2.0.min.js"></c:url>" type="text/javascript"></script>
        <script src=" <c:url value="views/assets/js/jquery.dataTables.min.js"></c:url>" type="text/javascript"></script>
        <script src=" <c:url value="views/assets/js/jquery.blockui.js"></c:url>" type="text/javascript"></script>
        <script src=" <c:url value="views/assets/js/materialPreloader.min.js"></c:url>" type="text/javascript"></script>
        <script src=" <c:url value="views/assets/js/materialize.min.js"></c:url>" type="text/javascript"></script>
        <script src=" <c:url value="views/assets/js/table-data.js"></c:url>" type="text/javascript"></script>
    </body>
</html>
