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
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Your Weapon Evidence App</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="index.html">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Menu</span></a>
    </li>

    <!-- Divider -->
<div sec:authorize="isAuthenticated()"> <%--    wyświetlanie treści tylko dla użytkownika zalogowanego --%>
    <hr class="sidebar-divider">
    <button onclick="window.location.href='/weapon/all'" class="rounded-circle border-0" id="sidebarToggle" ></button><br>
    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/weapon/all">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Lista Broni</span></a>
    </li>
    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/weapon/form">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Dodaj Broń</span></a>
    </li>
    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/#">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Trening</span></a>
    </li>
    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/#">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Zakupy</span></a>
    </li>
    <hr class="sidebar-divider">
    <li class="nav-item">
        <a class="nav-link" href="/weapon/archive/list">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Archiwum</span></a>
    </li>
    <hr class="sidebar-divider">
</div>
</ul>
<!-- End of Sidebar -->