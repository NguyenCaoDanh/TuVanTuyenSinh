<%-- 
    Document   : school
    Created on : Sep 3, 2023, 1:55:21 PM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${user.roleUserIdRoleuser.name == 'ROLE_ADMIN'}">
    <div class="text-right mb-3">
        <a href="<c:url value="/admin/school/${ds.idschool}" />" class="btn btn-success">Cập nhật</a>
    </div>
</c:if>
<c:forEach items="${school}" var="ds">
    <div class="intro-section">
        <div class="container">
            <div class="intro-text">
                <h1>${ds.tieuDe}</h1>
                <br>
                <p style="word-wrap:break-word;">${ds.description}<p>
                    <img src="${ds.imageSchool}" width="500px" height="300px" alt="alt"/>
            </div>
        </div>
    </div>
</c:forEach>
