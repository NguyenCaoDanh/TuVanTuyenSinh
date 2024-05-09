<%-- 
    Document   : register
    Created on : Aug 31, 2023, 2:56:24 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1 class="text-center text-info mt-1">Đăng ký</h1>
<c:url value="/register" var="action" />
<form:form method="post" action="${action}" onsubmit="return validateForm();" modelAttribute="user" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="avatar" />
    <form:hidden path="idusers" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" 
                    path="username" id="username" placeholder="Nhập username..." name="username"/>
        <label for="username">Tên đăng nhập</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="password" class="form-control" 
                    path="password" id="pwd" placeholder="Nhập mật khẩu..." name="password"/>
        <label for="pwd">Mật khẩu</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="password" class="form-control" 
                    path="password" id="confirmPwd" placeholder="Nhập lại mật khẩu..." name="password"/>
        <label for="confirmPwd">Nhập lại mật khẩu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control"
                    path="firstName" id="firstname" placeholder="Nhập firstname..." name="firstname"/>
        <label for="firstname">Họ</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control"
                    path="lastName" id="lastname" placeholder="Nhập lastname..." name="lastname"/>
        <label for="lastname">Tên</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control"
                    path="email" id="email" placeholder="Nhập email...." name="email"/>
        <label for="email">Email</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control"
                    path="file" id="avatar" name="avatar"/>
        <label for="avatar">Chọn avatar</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <input type="submit" value="Đăng ký" class="btn btn-danger" />
    </div>
</form:form>
<script>
    function validateForm() {
        var password = document.getElementById("pwd").value;
        var confirmPassword = document.getElementById("confirmPwd").value;

        if (password !== confirmPassword) {
            alert("Mật khẩu và nhập lại mật khẩu không trùng khớp!");
            return false;
        }
        return true;
    }
</script>