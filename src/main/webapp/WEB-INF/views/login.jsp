<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiekryniu
  Date: 13.07.2021
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona logowania</title>
</head>
<body>
Login
<form method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<br>
<br>
<%--Registry:--%>
<%--    <form:form method="post" modelAttribute="user">--%>
<%--    <form input path="id" type="hidden" name="id" value="${user.id}"/><br>--%>
<%--    User Name: <form:input path="username" name="username" value="${user.username}"/><br>--%>
<%--    Mail: <form:input path="mail" name="mail"  value="${user.mail}"/><br>--%>
<%--    Password: <form:input type="password" path="password" name="password"/>--%>
<%--    <input type="submit">--%>

<%--</form:form>--%>
</body>
</html>
