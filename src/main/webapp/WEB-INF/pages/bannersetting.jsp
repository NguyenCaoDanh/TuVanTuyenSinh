<%-- 
    Document   : AdminSettings
    Created on : Sep 1, 2023, 4:46:45 PM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<section class="container">
    <h1 class="text-center text-info mt-1">BANNERS</h1>
    <c:if test="${user.roleUserIdRoleuser.name == 'ROLE_ADMIN'}">
        <section class="container">
            <div class="text-right mb-3">
                <a href="<c:url value='/admin/banners' />" class="btn btn-info">Thêm ảnh banner</a>
            </div>
        </section>
    </c:if>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Hình ảnh</th>
                <th>Tác giả</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${banner}" var="ds">
                <tr>
                    <td>${ds.idbanner}</td>
                    <td><img src="${ds.image}" width="50px" height="50px"/></td>
                    <td>${ds.usersIdusers.firstName} ${ds.usersIdusers.lastName}</td>
                    <td>  
                        <c:url value="/api/banners/${ds.idbanner}" var="apiDel" />
                        <a href="<c:url value="/admin/banners/${ds.idbanner}" />" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="delPost('${apiDel}', ${ds.idbanner})">Xóa</button>
                    </td>
                </tr>   
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/assets/js/main1.js" />"></script>
