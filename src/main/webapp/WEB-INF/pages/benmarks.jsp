<%-- 
    Document   : AdminSettings
    Created on : Sep 1, 2023, 4:46:45 PM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<section class="container">
    <h2 class="text-center text-info mt-1 fw-bold text-dark">ĐIỂM CHUẨN TRƯỜNG ĐẠI HỌC MỞ THÀNH PHỐ HỒ CHÍ MINH</h2>
    <c:if test="${user.roleUserIdRoleuser.name == 'ROLE_ADMIN'}">
        <section class="container">
            <div class="text-right mb-3">
                <a href="<c:url value='/admin/benmarks' />" class="btn btn-info">Thêm điểm chuẩn</a>
            </div>
        </section>
    </c:if>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Ngành</th>
                <th>Điểm Thi THPT</th>
                <th>Điểm Học Bạ</th>
                <th>Điểm DGNL</th>
                <th>Năm</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${benmarks}" var="ds">
                <tr>
                    <td>${ds.majorsIdmajors.majorname}</td>
                    <td>${ds.diemthpt}</td>
                    <td>${ds.diemhocba}</td>
                    <td>${ds.diemdgnl}</td>
                    <td>${ds.year}</td>
                    <c:if test="${user.roleUserIdRoleuser.name == 'ROLE_ADMIN'}">
                        <td>  
                            <c:url value="/api/benmarks/${ds.idbenmarks}" var="apiDel" />
                            <a href="<c:url value="/admin/benmarks/${ds.idbenmarks}" />" class="btn btn-success">Cập nhật</a>
                            <button class="btn btn-danger" onclick="delPost('${apiDel}', ${ds.idbenmarks})">Xóa</button>
                        </td>
                    </c:if>
                </tr>   
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/assets/js/main1.js" />"></script>
