<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.08.2018
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/css/bootstrap.min.css'>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/css/error.css'>
</head>
<body>
<div class="error-wall load-error">
    <div class="error-container">
        <h1>oh no...</h1>
        <h3>We have had an error</h3>
        <h4>Error 404</h4>
        <p>May be go to <a href="/">main</a>? </p>
   </div>
</div>
</body>
</html>
