<%-- 
    Document   : livestreams
    Created on : Sep 29, 2023, 6:08:49 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-1">Quản Lý Người Dùng</h1>
<c:url value="/admin/user1" var="action" />
<form:form method="post" action="${action}" modelAttribute="users" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="idusers" />
    <form:hidden path="avatar" />

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" 
                    path="username" id="username"  name="username" readonly="true"/>
        <label for="username">Tên đăng nhập</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control"
                    path="firstName" id="firstname" name="firstname" readonly="true"/>
        <label for="firstname">Họ</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control"
                    path="lastName" id="lastname"  name="lastname" readonly="true"/>
        <label for="lastname">Tên</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control"
                    path="file" id="avatar" name="avatar"/>
        <label for="postImg">Chọn hình</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control"
                    path="email" id="email"  name="email" readonly="true"/>
        <label for="lastname">Email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="roleUserIdRoleuser" name="roleUserIdRoleuser" 
                     path="roleUserIdRoleuser">
            <c:forEach items="${roleusers}" var="re">
                <c:choose>
                    <c:when test="${re.idRoleuser == users.roleUserIdRoleuser.idRoleuser}">
                        <option value="${re.idRoleuser}" selected>${re.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${re.idRoleuser}" selected>${re.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="des">Chức năng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${users.idusers == null}">Thêm</c:when>
                <c:otherwise>Cập nhật</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>