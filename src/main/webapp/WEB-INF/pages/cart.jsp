<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="cart" type="com.es.phoneshop.model.Cart" scope="request"/>

<html>
<head>
    <title>Cart</title>
</head>
    <jsp:include page="/WEB-INF/pages/header.jsp"/>
<body>

<div class="row mt-5">
    <div class="col-md-4" >
        <h5 style="text-align: center">Product Cart</h5>
    </div>
    <div class="col-md-4 justify-content-center">
        <table class="table-dark table">
            <thead>
            <tr>
                <td>Id</td>
                <td>Code</td>
                <td>Description</td>
                <td>Price</td>
                <td>Currency</td>
                <td>Quantity</td>
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
            <c:forEach var="cartItem" items="${cart.cartItems}">
                <tr>
                    <td><c:out value="${cartItem.product.id}"/></td>
                    <td>
                        <a href = "<c:url value = "/products/${cartItem.product.id}" />"><c:out value="${cartItem.product.code}"/></a>
                    </td>
                    <td><c:out value="${cartItem.product.description}"/></td>
                    <td><c:out value="${cartItem.product.price}"/></td>
                    <td><c:out value="${cartItem.product.currency}"/></td>
                    <td><c:out value="${cartItem.quantity}"/></td>
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