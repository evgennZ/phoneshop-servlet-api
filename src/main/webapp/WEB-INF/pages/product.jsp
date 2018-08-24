<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/css/bootstrap.min.css'>
</head>
<body>

<div class="row mt-5">
    <div class="col-md-4" >
        <h5 style="text-align: center">Product info</h5>
    </div>
    <div class="col-md-4 justify-content-center">
        <table class="table-dark table">
            <thead>
            <tr>
                <td>Id</td>
                <td>Code</td>
                <td>Description</td>
                <td>Price</td>
                <td>Stock</td>
                <td>Currency</td>
            </tr>
            </thead>
            <tr>
                <%--      <td>
                        <img src="https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/${product.imageUrl}">
                      </td>--%>
                <td>${product.id}</td>
                <td>${product.code}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.stock}</td>
                <td>${product.currency}</td>
            </tr>
        </table>
    </div>
</div>


</body>
</html>
