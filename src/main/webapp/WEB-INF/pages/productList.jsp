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
    <title>Products List</title>
</head>
<body>

<jsp:include page="/WEB-INF/pages/header.jsp"/>

<div class="row mt-5">
    <div class="col-md-4">
        <h5 style="text-align: center">Product list</h5>
    </div>
    <div class="col-md-4 justify-content-center">
        <table class="table ">
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
                    <td>
                        <a href="/products/${product.id}">${product.id}</a>
                    </td>
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

<footer>
    <jsp:include page="/WEB-INF/pages/footer.jsp"/>
</footer>

</html>

