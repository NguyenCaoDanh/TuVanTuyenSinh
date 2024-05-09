<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-1">Cập nhật thông tin</h1>
<c:url value="/accoutsetting" var="action" />
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
        <form:input type="password" class="form-control" 
                    path="password" id="password"  name="password" readonly="false"/>
        <label for="username">Mật Khẩu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control"
                    path="firstName" id="firstname" name="firstname" readonly="false"/>
        <label for="firstname">Họ</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control"
                    path="lastName" id="lastname"  name="lastname" readonly="false"/>
        <label for="lastname">Tên</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control"
                    path="file" id="avatar" name="avatar"/>
        <label for="postImg">Chọn hình</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control"
                    path="email" id="email"  name="email" readonly="false"/>
        <label for="lastname">Email</label>
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
