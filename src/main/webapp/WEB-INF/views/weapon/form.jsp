<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiekryniu
  Date: 13.07.2021
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj broń</title>
</head>
<body>
    <form:form method="post" modelAttribute="weapon">
        <form input path="id" type="hidden" name="id" value="${weapons.id}"/><br>
        Nazwa klamki: <form:input path="name" name="name" value="${weapons.name}"/><br>
        Amunicja: <form:select path="ammo"><br>
        <form:option value="0">Wybierz kaliber</form:option><br>
        <form:options items="${ammunitions}" itemLabel="caliber" itemValue="id"/><br>
        </form:select><br>
        Rodzaj pozwolenia:<br><form:select path="permission"><br>
        <form:option value="0">Wybierz pozwolenie</form:option><br>
        <form:options items="${permissions}"/>
        </form:select><br>
        <input type="submit">
    </form:form>




</body>
</html>
