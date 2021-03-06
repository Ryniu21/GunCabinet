<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiekryniu
  Date: 12.08.2021
  Time: 22:28
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

    <title><spring:message code="weaponshow.title"/></title>

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
                    <h1 class="h3 mb-0 text-gray-800"></h1>
                    <%--                    <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i--%>
                    <%--                            class="fas fa-download fa-sm text-white-50"></i> Lista u??ytkownik??w</a>--%>
                </div>
                <%--                HERE INCLUDE CONTENT--%>
                <div>
                    <h2><spring:message code="weaponshow.header2"/>: </h2>
                    <table class="table">
                        <%--                        <tr>--%>
                        <%--                            <th>ID</th>--%>
                        <%--                            <td>${weapon.id}</td>--%>
                        <%--                            <br>--%>
                        <%--                        </tr>--%>
                        <tr>
                            <th><spring:message code="weaponshow.name"/></th>
                            <td>${weapon.name}</td>
                            <br>
                        </tr>
                        <tr>
                            <th><spring:message code="weaponshow.caliber"/>:</th>
                            <td>${weapon.caliber.name}</td>
                            <br>
                        </tr>
                        <tr>
                            <th><spring:message code="weaponshow.permission"/></th>
                            <td>${weapon.permission}</td>
                            <br>
                        </tr>
                        <tr>
                            <th><spring:message code="weaponshow.ammoShoot"/></th>
                            <td>${weapon.ammoShoot}</td>
                            <br>
                        </tr>
                        <tr>
                            <th><spring:message code="weaponshow.dateBought"/></th>
                            <td>${weapon.dateBought}</td>
                            <br>
                        </tr>
                        <tr>
                            <th><spring:message code="weaponshow.dateSold"/></th>
                            <td>${weapon.dateSold}</td>
                            <br>
                        </tr>
                    </table>

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
                    <span aria-hidden="true">??</span>
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
