<%-- 
    Document   : Post
    Created on : Aug 31, 2023, 5:17:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-1">Quản lý hình ảnh banners</h1>
<c:url value="/admin/banners" var="action" />
<form:form method="post" action="${action}" modelAttribute="banner" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="idbanner" />
    <form:hidden path="image" />
     <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control"
                    path="file" id="image" name="image"/>
        <label for="image">Chọn hình</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${banner.idbanner == null}">Thêm</c:when>
                <c:otherwise>Cập nhật</c:otherwise>
            </c:choose>
        </button>
    </div>

</form:form>