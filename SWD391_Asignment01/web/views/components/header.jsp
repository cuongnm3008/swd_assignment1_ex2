<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark menu-header">
    <style>
        .menu-header{
            background-color: #563D7C;
            display: flex;
            justify-content: space-around;
            background-color: #563D7C;
        }

        #welcome{
            line-height: 39px;
            padding-right: 36px;
            color: wheat;
            font-size: 18px;
        }
    </style>
    <div>
        <a href="<%=request.getContextPath()%>/home" style="font-size: 25px;" class="navbar-brand">BookStore Online</a>
    </div>
    <ul class="navbar-nav">
        <c:if test="${not empty USERMODEL}">
            <li><span id="welcome">Welcome ${USERMODEL.name}</span></li>
            <li><a href="<%=request.getContextPath()%>/cart"
                   class="nav-link text-white">Cart: <span style="color: wheat; font-size: 20px;"  >${totalItem}</span> Item</a></li>
            <li><a href="<%=request.getContextPath()%>/logout"
                   class="nav-link">logout</a></li>
            </c:if>
            <c:if test="${empty USERMODEL}">
            <li><a href="<%=request.getContextPath()%>/login"
                   class="nav-link">Login</a></li>
            <li><a href="<%=request.getContextPath()%>/register"
                   class="nav-link">Register</a></li>
            </c:if>       
    </ul>
</nav>
