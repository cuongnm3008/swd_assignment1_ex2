<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Review</title>
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
            <h3>Please Review Before Paying</h3>

            <form action="execute_payment" method="post">
                <table id="review-table" style="width: 60%;display: table;margin-left: 300px;">
                    <tr>
                        <td colspan="2"><b>Transaction Details:</b></td>
                        <td>
                            <input type="hidden" name="paymentId" value="${param.paymentId}" />
                            <input type="hidden" name="PayerID" value="${param.PayerID}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td>${transaction.description}</td>
                    </tr>
                    <tr>
                        <td>Subtotal:</td>
                        <td>${transaction.amount.details.subtotal} USD</td>
                    </tr>
                    <tr>
                        <td>Shipping:</td>
                        <td>${transaction.amount.details.shipping} USD</td>
                    </tr>
                    <tr>
                        <td>Tax:</td>
                        <td>${transaction.amount.details.tax} USD</td>
                    </tr>
                    <tr>
                        <td>Total:</td>
                        <td>${transaction.amount.total} USD</td>
                    </tr>
                    <tr><td><br/></td></tr>
                    <tr>
                        <td colspan="2"><b>Payer Information:</b></td>
                    </tr>
                    <tr>
                        <td>First Name:</td>
                        <td>${payer.firstName}</td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td>${payer.lastName}</td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>${payer.email}</td>
                    </tr>
                    <tr><td><br/></td></tr>
                    <tr>
                        <td colspan="2"><b>Shipping Address:</b></td>
                    </tr>
                    <tr>
                        <td>Recipient Name:</td>
                        <td>${shippingAddress.recipientName}</td>
                    </tr>
                    <tr>
                        <td>House number:</td>
                        <td>${shippingAddress.line1}</td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td>${shippingAddress.city}</td>
                    </tr>
                    <tr>
                        <td>State:</td>
                        <td>${shippingAddress.state}</td>
                    </tr>
                    <tr>
                        <td>Country Code:</td>
                        <td>${shippingAddress.countryCode}</td>
                    </tr>
                    <tr>
                        <td>Postal Code:</td>
                        <td>${shippingAddress.postalCode}</td>
                    </tr>
                    <tr style="padding: 30px 0px;display: block;">
                        <td colspan="2" align="center">
                            <input class="btn btn-success" style="background-color:#3A954E;" type="submit" value="Pay Now" />
                        </td>
                    </tr> 

                </table>
            </form>
    </body>
</html>