<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="products" type="java.util.ArrayList" scope="request"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%--<link rel='stylesheet' href='${pageContext.request.contextPath}/WEB-INF/resources/css/bootstrap.min.css'>--%>
    <%--<script type='text/javascript' src='/WEB-INF/resources/js/bootstrap.min.js'></script>--%>
</head>
<body>

<div class="row mt-5">
    <div class="col-md-4">
        <h1> Hello from product list!</h1>
    </div>
    <div class="col-md-4">
        <table>
            <thead>
            <tr>
                <td>Id</td>
                <td>Code</td>
                <td>Description</td>
                <td>Price</td>
                <td>Stock</td>
            </tr>
            </thead>
            <c:forEach var="product" items="${products}">
                <tr>
                        <%--      <td>
                                <img src="https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/${product.imageUrl}">
                              </td>--%>
                    <td>${product.id}</td>
                    <td>${product.code}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.stock}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>

