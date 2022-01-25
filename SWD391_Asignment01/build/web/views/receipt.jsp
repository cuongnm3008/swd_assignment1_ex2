<%@ page language="java" contentType="text/html; charset=UTF-8"        
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Payment Receipt</title>
        <style type="text/css">
            table { border: 0; }
            table td { padding: 5px; }
        </style>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="views/assets/css/alpha.min.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/custom.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/jquery.dataTables.min.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/materialize.min.css"></c:url>">
        <link rel="stylesheet" href="<c:url value="views/assets/css/bootstrap.min"></c:url>">
        <%@include file="components/header.jsp" %>
    </head>
    <body>
        <div align="center">
            <h3>Payment Done. Thank you for purchasing our products</h3>
            <br/>
            <h5>Receipt Details:</h5>

            <table style="width: 32%;display: table;margin-left: 130px;">
                <tr>
                    <td><b>Merchant:</b></td>
                    <td>Company ABC Ltd.</td>
                </tr>
                <tr>
                    <td><b>Payer:</b></td>
                    <td>${payer.firstName} ${payer.lastName}</td>      
                </tr>
                <tr>
                    <td><b>Description:</b></td>
                    <td>${transaction.description}</td>
                </tr>
                <tr>
                    <td><b>Subtotal:</b></td>
                    <td>${transaction.amount.details.subtotal} $</td>
                </tr>
                <tr>
                    <td><b>Shipping:</b></td>
                    <td>${transaction.amount.details.shipping} $</td>
                </tr>
                <tr>
                    <td><b>Tax:</b></td>
                    <td>${transaction.amount.details.tax} $</td>
                </tr>
                <tr>
                    <td><b>Total:</b></td>
                    <td>${transaction.amount.total} $</td>
                </tr>
            </table>
        </form
    </div>
</body>
</html>