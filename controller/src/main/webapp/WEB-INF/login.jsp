<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="resources/assets/css/loginStyle.css">
</head>
<body>
<section class="container">
    <div class="login">
        <h1>Войти в личный кабинет</h1>
        <form method="post" action="${pageContext.request.contextPath}/">
            <p><input type="text" name="login1" value="" placeholder="Логин или Email"></p>
            <p><input type="password" name="password" value="" placeholder="Пароль"></p>
            <p class="submit"><input type="submit" name="commit" value="Войти"></p>
        </form>
        <form method="post" action="${pageContext.request.contextPath}/">
            Manager: <select name="login">
            <c:forEach var="manager" items="${managers}" varStatus="status">
            <option value="${manager.id}">${manager.name}</option>
            </c:forEach>
            <input type="hidden" name="Rol" value="manager">
            <p class="submit"><input type="submit" name="commit" value="Войти"></p>
        </form>
        <form method="post" action="${pageContext.request.contextPath}/">
            Client: <select name="login">
            <c:forEach var="client" items="${clients}" varStatus="status">
                <option value="${client.id}">${client.name}</option>
            </c:forEach>
            <input type="hidden" name="Rol" value="client">
            <p class="submit"><input type="submit" name="commit" value="Войти"></p>
        </form>
    </div>
</section>
</body>
</html>
