<%-- 
    Document   : AdminSettings
    Created on : Sep 1, 2023, 4:46:45 PM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<section class="container">
    <h1 class="text-center text-info mt-1">DANH SÁCH KHOA</h1>
    <c:if test="${user.roleUserIdRoleuser.name == 'ROLE_ADMIN'}">
        <section class="container">
            <div class="text-right mb-3">
                <a href="<c:url value='/admin/faculties' />" class="btn btn-info">Thêm Khoa</a>
            </div>
            <div class="text-right mb-3 " small-search-box>
                <input type="text" id="searchInput" class="form-control" name ="kw" placeholder="Tìm kiếm...">
                <button class="btn btn-info" onclick="searchPosts()">Tìm kiếm</button>
            </div> 
        </section>
    </c:if>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Mã Khoa</th>
                <th>Tên Khoa</th>
                <th>Giới thiệu</th>
                <th>Chương trình đạo tào</th>
                <th>Website</th>
                <th>Video</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach items="${faculty}" var="ds">
                <tr>
                    <td>${ds.idfaculty}</td>
                    <td>${ds.facultyname}</td>
                    <td>${ds.gioiThieu}</td>
                    <td>${ds.moTaCTDT}</td>
                    <td>${ds.website}</td>
                    <td>${ds.introvideo}</td>
                    <td>  
                        <c:url value="/api/faculties/${ds.idfaculty}" var="apiDel" />
                        <a href="<c:url value="/admin/faculties/${ds.idfaculty}"/>" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="delPost('${apiDel}', ${ds.idfaculty})">Xóa</button>
                    </td>
                </tr>   
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/assets/js/main1.js" />"></script>
