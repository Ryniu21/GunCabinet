<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiekryniu
  Date: 31.07.2021
  Time: 00:42
  To change this template use File | Settings | File Templates.
--%>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/weapon/all">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Your Weapon Evidence App</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">


    <!-- Divider -->
<div sec:authorize="isAuthenticated()"> <%--    wyświetlanie treści tylko dla użytkownika zalogowanego --%>
    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/about">
            <span>About</span></a>
    </li>

    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/weapon/all">
            <span><spring:message code="sidebar.weaponlist"/></span></a>
    </li>

    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/weapon/form">
            <span><spring:message code="sidebar.addweapon"/></span></a>
    </li>
<%--    <hr class="sidebar-divider">--%>
<%--    <li class="nav-item">--%>
<%--        <a class="nav-link" href="/action/training">--%>
<%--            <span><spring:message code="sidebar.training"/></span></a>--%>
<%--    </li>--%>

    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/action/traininglist">
            <span>Treningi</span></a>
    </li>

<%--    <hr class="sidebar-divider">--%>
<%--    <li class="nav-item">--%>
<%--        <a class="nav-link" href="/ammunition/form">--%>
<%--            <span><spring:message code="sidebar.shopping"/></span></a>--%>
<%--    </li>--%>

    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/weapon/archive/list">
            <span><spring:message code="sidebar.archive"/></span></a>
    </li>
    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/ammunition/list">
            <span><spring:message code="sidebar.ammolist"/></span></a>
    </li>
    <hr class="sidebar-divider">
    <sec:authorize access="hasRole('ADMIN')">
    <li class="nav-item">
        <a class="nav-link" href="/admin/adminlist">
            <span>Lista użytkowników</span></a>
    </li>
    <hr class="sidebar-divider">
    </sec:authorize>
    <sec:authorize access="isAuthenticated()"> <%--    wyświetlanie treści tylko dla użytkownika zalogowanego --%>
        <form action="<c:url value="/logout"/>" method="post">
            <input class="btn btn-primary" type="submit" value="<spring:message code="sidebar.logout"/>">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </sec:authorize>
</div>
</ul>
<!-- End of Sidebar -->