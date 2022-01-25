<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Home</title>
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
                <h3 style="text-align: center;">Search Book</h3>
                <hr style="width: 60%">
                <main class="mn-inner">

                    <div class="col s12 m12 l12">
                        <div class="card">
                            <div class="card-content">
                                <table id="example" class="display responsive-table datatable-example">
                                    <thead>
                                        <tr>
                                            <th>Title</th>
                                            <th>Author</th>
                                            <th>Publisher</th>
                                            <th>Description</th>
                                            <th>Price</th>
                                            <th style="text-align: center;">Add to Cart</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="book" items="${listBook}">
                                            <tr>
                                                <td><c:out value="${book.title}" /></td>
                                                <td><c:out value="${book.author}" /></td>
                                                <td><c:out value="${book.publisher}" /></td>
                                                <td><c:out value="${book.description}" /></td>
                                                <td>${book.price} $</td>
                                                <td style="text-align: center;">                                               
                                                    <form action="add-to-cart" method="post">
                                                        <input type="hidden" name="bookId" value="${book.id}">
                                                        <input type="hidden" name="price" value="${book.price}">
                                                        <button type="submit" class="btn" style="background-color:#3A954E;">
                                                            Add
                                                        </button>
                                                    </form>
                                                </td>
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
