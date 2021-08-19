<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><spring:message code="form.title"/></title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">

</head>


<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <%@ include file="../include/sidebar.jsp" %>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <%@ include file="../include/header.jsp" %>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800"><spring:message code="form.header1"/></h1>
                    <%--                    <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i--%>
                    <%--                            class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników</a>--%>
                </div>
                <%--                HERE INCLUDE CONTENT--%>
                <div>
                    <h2><spring:message code="form.header2"/>: </h2>
                    <body>
                    <form:form method="post" modelAttribute="weapon">
                        <form input path="id" type="hidden" name="id" value="${weapons.id}"/><br>
                        <spring:message code="form.weaponname"/>: <form:input path="name" name="name" value="${weapons.name}"/><br>
                        <font color="red"> <form:errors path="name">Uzupełnij prawidłowo nazwę broni</form:errors></font>                        <spring:message code="form.caliber"/>: <form:select path="caliber"><br>
                        <form:option value="0"><spring:message code="form.choosecaliber"/></form:option><br>
                        <form:options items="${calibers}" itemValue="id" itemLabel="name" path="ammo.caliber"/><br>
                        </form:select><br>
                        <font color="red"> <form:errors path="ammo.caliber">Uzupełnij prawidłowo kaliber</form:errors></font>
                        <spring:message code="form.permissiontype"/>:<form:select path="permission"><br>
                        <form:option value="0"><spring:message code="form.choosepermission"/></form:option><br>
                        <form:options items="${permissions}"/>
                        </form:select><br>
                        <font color="red"> <form:errors path="permission">Uzupełnij prawidłowo kaliber</form:errors></font>
                        <spring:message code="form.dateBought"/>: <form:input type="date" path="dateBought" name="dateBought"/><br>
                        <font color="red"> <form:errors path="dateBought">Uzupełnij prawidłowo datę zakupu</form:errors></font>
                        <form input type="hidden" path="dateSold" name="dateSold"/>
                        <spring:message code="form.ammoshoot"/>: <form:input modelAttribute="weapon" path="ammoShoot" name="ammoShoot"/><br>
                        <font color="red"><form:errors path="ammoShoot">Uzupełnij prawidłowo wystrzeloną amunicję</form:errors></font><br>
                        <form input modelAttribute="ammo" path="id" name="id" type="hidden"/>
                        <form input path="weapon.user" name="weapon.user" type="hidden"/>
                        <input type="submit" value="Dodaj">
                    </form:form>

                    </body>

                </div>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->

        <%@include file="../include/footer.jsp"%>


    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<%@include file="../include/jsscripts.jsp"%>

</body>


</html>
