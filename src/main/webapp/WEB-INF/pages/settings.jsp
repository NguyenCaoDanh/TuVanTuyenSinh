<%-- 
    Document   : AdminSettings
    Created on : Sep 1, 2023, 4:46:45 PM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <h1 class="text-center text-info mt-1">QUẢN LÝ BÀI VIẾT</h1>
    <section class="container">
        <div class="text-right mb-3">
            <a href="<c:url value='/admin/posts' />" class="btn btn-info">Đăng bài</a>
        </div>
        <div class="text-right mb-3 " small-search-box>
            <input type="text" id="searchInput" class="form-control" name ="kw" placeholder="Tìm kiếm...">
            <button class="btn btn-info" onclick="searchPosts()">Tìm kiếm</button>
        </div>
    </section>

    <c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="<c:url value="/posts/" />">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/posts/" var="pageUrl">
                        <c:param name="page" value="${i}"></c:param>
                    </c:url>
                <li class="page-item"><a class="page-link" onclick="reload()" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Tiêu đề</th>
                <th>Loại Bài Đăng</th>
                <th>Tác Giả</th>
                <th>Hình ảnh</th>
                <th>Tên Khoa</th>
                <th>Loại đào tạo</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${posts}" var="ds">
                <tr>
                    <td>${ds.idpost}</td>
                    <td>${ds.postName}</td>
                    <td>${ds.posttype}</td>
                    <td>${ds.usersIdusers.firstName} ${ds.usersIdusers.lastName}</td>
                    <td><img src="${ds.postImg}" width="30px" height="20px"/></td>
                    <td>${ds.facultyIdfaculty.facultyname}</td>
                    <td>${ds.admissionIdadmission.typeoftraining}</td>
                    <td>
                        <c:url value="/api/posts/${ds.idpost}" var="apiDel" />
                        <a href="<c:url value="/admin/posts/${ds.idpost}" />" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="delPost('${apiDel}', ${ds.idpost})">Xóa</button>
                    </td>
                </tr>   
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/assets/js/main1.js" />"></script>
