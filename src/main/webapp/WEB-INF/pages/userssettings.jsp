<%-- 
    Document   : users
    Created on : Sep 22, 2023, 2:17:03 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<section class="container">
    <h1 class="text-center text-info mt-1">DANH SÁCH NGƯỜI DÙNG</h1>  
    <c:if test="${user.roleUserIdRoleuser.name == 'ROLE_ADMIN'}">
        <div class="text-right mb-3 " small-search-box>
            <input type="text" id="searchInput" class="form-control" name ="kw" placeholder="Tìm kiếm...">
            <button class="btn btn-info" onclick="searchPosts()">Tìm kiếm</button>
        </div>
    </c:if>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Tài khoản</th>
                <th>Họ</th>
                <th>Tên</th>
                <th>Email</th>
                <th>Chức năng</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="ds">
                <tr>
                    <td>${ds.idusers}</td>
                    <td>${ds.username}</td>
                    <td>${ds.firstName}</td>
                    <td>${ds.lastName}</td>
                    <td>${ds.email}</td>
                    <td>${ds.roleUserIdRoleuser.name}</td>
                    <td>  
                        <c:url value="/api/users/${ds.idusers}" var="apiDel" />
                        <a href="<c:url value="/admin/user1/${ds.idusers}"/>" class="btn btn-success">Cập nhật</a> 
                    </td>
                </tr>   
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/assets/js/main1.js" />"></script>