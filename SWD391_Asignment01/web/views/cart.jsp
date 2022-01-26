<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Cart</title>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="views/assets/css/alpha.min.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/custom.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/jquery.dataTables.min.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/materialize.min.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/bootstrap.min"></c:url>">
        <%@include file="components/header.jsp" %>
    </head>
    <body>
        <br>
        <div class="row">
            <div class="container" style="width: 100% !important;">
                <h3 style="text-align: center;">Cart</h3>
                <hr style="width: 60%">
                <main class="mn-inner">

                    <div class="col s12 m12 l12">
                        <div class="card">
                            <div class="card-content">
                                <table id="example" class="display responsive-table datatable-example">
                                    <thead>
                                        <tr>
                                            <th>Book Name</th>
                                            <th>Author</th>
                                            <th>Publisher</th>
                                            <th>Quantity</th>
                                            <th>Total Price</th>
                                            <th style="text-align: center;">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${listBook}">
                                            <tr>
                                        <form action="<%=request.getContextPath()%>/payment" method="get">
                                            <td><c:out value="${item.bookName}" /></td>
                                            <td><c:out value="${item.author}" /></td>
                                            <td><c:out value="${item.publisher}" /></td>
                                            <td><c:out value="${item.quantity}" /></td>
                                            <td><c:out value="${item.totalPrice}" /> $</td>
                                            <td style="text-align: center;">                                               
                                                <input type="hidden" name="cartId" value="${item.cartId}">
                                                <button type="submit" class="btn" style="background-color:#3A954E; color: wheat">
                                                    Buy
                                                </button>
                                            </td>
                                        </form>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
            </div>
        </main>
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
