<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiekryniu
  Date: 22.07.2021
  Time: 00:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona rejestracji</title>
</head>
<body>
    <form:form method="post" modelAttribute="user">
    <form input path="id" type="hidden" name="id" value="${user.id}"/><br>
        <spring:message code="login.username"/>: <form:input path="username" name="username" value="${user.username}"/><br>
        <spring:message code="login.emailadress"/>: <form:input path="mail" name="mail"  value="${user.mail}"/><br>
        <spring:message code="login.password"/>: <form:input type="password" path="password" name="password"/><br>
    <input type="submit" value=<spring:message code="login.registryaction"/>>
</form:form>

</body>
</html>
