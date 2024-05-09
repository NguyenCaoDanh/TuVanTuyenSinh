<%-- 
    Document   : Post
    Created on : Aug 31, 2023, 5:17:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info mt-1">Thông tin trường đại học mở thành phố Hồ Chí Minh</h1>
<c:url value="/admin/school" var="action" />
<form:form method="post" action="${action}" modelAttribute="school" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="idschool" />
     <form:hidden path="imageSchool" />

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" 
                    path="tieuDe" id="tieude" placeholder="Tên tiêu đề" />
        <label for="name">Tên tiêu đề</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:textarea  rows="10" cols="148"
                        path="description" id="noidung" placeholder="Nội dung" />
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control"
                    path="file" id="imageSchool" name="imageSchool"/>
        <label for="imageSchool">Chọn hình</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${school.idschool == null}">Thêm</c:when>
                <c:otherwise>Cập nhật</c:otherwise>
            </c:choose>
        </button>
    </div>

</form:form>