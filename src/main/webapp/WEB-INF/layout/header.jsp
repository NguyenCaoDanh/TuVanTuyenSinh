<%-- 
    Document   : header
    Created on : Jul 29, 2023, 7:47:28 AM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="action" />
<section class="mb-3 mt-3">
    <div class="">
        <div class="row justify-content-between">
            <div class="col-md-8 order-md-last">
                <div class="row">
                    <div class="col-md-6 text-center">
                        <a class="navbar-brand" href="${action}">CỔNG THÔNG TIN TƯ VẤN TUYỂN SINH</br>TRƯỜNG ĐẠI HỌC MỞ THÀNH PHỐ HỒ CHÍ MINH</a>
                    </div>
                    <div class="col-md-6 d-md-flex justify-content-end mb-md-0 mb-3">
                        <form class="searchform order-lg-last" action="${action}">
                            <div class="form-group d-flex">
                                <input type="text" class="form-control pl-3" name="kw" placeholder="Tìm kiếm theo hệ đào tạo..">
                                <button type="submit" class="form-control search">Tìm</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-4 d-flex">
                <div class="social-media">
                    <p class="mb-0 d-flex">
                        <img src="https://res.cloudinary.com/dev7q6f9g/image/upload/v1694165864/oaetvtnfrjfrf0emhojk.png"/>
                    </p>
                </div>
            </div>
        </div>
    </div>

    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="fa fa-bars"></span> Menu
            </button>
            <div class="collapse navbar-collapse" id="ftco-nav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active"><a href="<c:url value='/'/>" class="nav-link">Trang Chủ</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Hệ</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown04">
                            <c:forEach items="${admission}" var="ds">
                                <a class="dropdown-item" href="#${ds.idadmission}">${ds.typeoftraining}</a>
                            </c:forEach>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Khoa</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown04">
                            <c:forEach items="${faculties}" var="ds">
                                <a class="dropdown-item" href="<c:url value='/facultiesdetail/${ds.idfaculty}'/>">${ds.facultyname}</a>
                            </c:forEach>
                        </div>
                    </li>
                    <li class="nav-item"><a href="<c:url value='/school'/>" class="nav-link">Giới thiệu</a></li>
                    <li class="nav-item"><a href="<c:url value='/benmarks'/>" class="nav-link">Điểm chuẩn</a></li>
                    <li class="nav-item"><a href="<c:url value='/livestreamlist/'/>" class="nav-link">Livestreams</a></li>
                     <li class="nav-item"><a href="<c:url value='/gpt/'/>" class="nav-link">AI ChatGPT</a></li>
                    <li class="nav-item"><a href="<c:url value='/lienhe'/>" class="nav-link">Liên hệ</a></li>
                </ul>
            </div>
            <ul class="navbar-nav ml-auto">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <c:if test="${user.roleUserIdRoleuser.name == 'ROLE_ADMIN'}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">QUẢN LÝ</a>
                                <div class="dropdown-menu" aria-labelledby="dropdown04">
                                    <a class="dropdown-item" href="<c:url value='/admin/facultysetting/' />">Quản Lý Khoa</a>
                                    <a class="dropdown-item" href="<c:url value='/admin/majorsetting/' />">Quản lý Ngành</a>
                                    <a class="dropdown-item" href="<c:url value='/admin/settings/' />">Quản lý Bài Viết</a>
                                    <a class="dropdown-item" href="<c:url value='/admin/livestreamsetting/' />">Quản lý Livestream</a>
                                    <a class="dropdown-item" href="<c:url value='/admin/bannersetting/' />">Quản lý Banners</a>
                                    <a class="dropdown-item" href="<c:url value='/admin/userssettings/' />">Quản lý Người Dùng</a>
                                </div>
                            </li>
                        </c:if>
                        <div id="avatar-container" class="dropdown" style="position: relative; margin-left: 30px;">
                            <a class="" href="#" role="button" id="avatar-dropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <div class="avatar" style="position: relative;">
                                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                                        <img src="${user.avatar}" width="60px" height="60px" id="user-avatar" />
                                    </c:if>
                                </div>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="avatar-dropdown" style="position: absolute; right: auto; left: -40px; top: 100%; min-width: 100px;">
                                <c:if test="${pageContext.request.userPrincipal.name != null}">
                                    <div class="username text-center">
                                        <a class="dropdown-item" href="<c:url value='/accoutsetting' />">
                                            ${pageContext.request.userPrincipal.name}
                                        </a>
                                    </div>
                                    <hr class="username-separator" />
                                </c:if>
                                <div class="logout"><a class="dropdown-item" href="<c:url value='/logout' />">LOG OUT</a></div>
                            </div>
                        </div>
                </div>
                </li>
            </c:when>
            <c:otherwise>
                <li class="nav-item">
                    <a href="<c:url value='/login' />" class="nav-link">Đăng Nhập</a>
                </li>
                <li class="nav-item">
                    <a href="<c:url value='/register' />" class="nav-link">Đăng Ký</a>
                </li>
            </c:otherwise>
        </c:choose>
        </ul>
        </div>
    </nav>
    <!-- END nav -->
</section>
<script>
    $(document).ready(function () {
        $("#avatar-dropdown").click(function (e) {
            e.preventDefault();


            $("#avatar-container").toggleClass("show");
        });
    });
</script>
<script>
    $(document).ready(function () {
        $("#notification-dropdown").hide();
        $("#notification-icon").click(function (event) {
            event.stopPropagation();
            $.ajax({
                url: "/get-notifications",
                method: "GET",
                success: function (data) {
                    $("#notification-dropdown").html(data);
                    $("#notification-dropdown").show();
                }
            });
        });
        $(document).click(function () {
            $("#notification-dropdown").hide();
        });
        $("#notification-dropdown-container").click(function (event) {
            event.stopPropagation();
        });
    });
</script>


<script>
    function toggleManagementMenu() {
        var managementMenu = document.getElementById("management-menu");
        if (managementMenu.style.display === "none") {
            managementMenu.style.display = "block";
        } else {
            managementMenu.style.display = "none";
        }
    }
</script>


