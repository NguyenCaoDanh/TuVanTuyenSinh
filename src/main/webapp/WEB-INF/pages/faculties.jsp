<%-- 
    Document   : faculty
    Created on : Aug 31, 2023, 5:17:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-1">Quản lý Khoa</h1>
<c:url value="/admin/faculties " var="action" />
<form:form method="post" action="${action}" modelAttribute="faculty" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="idfaculty" />
    <form:hidden path="introvideo"/>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" 
                    path="facultyname" id="ten" placeholder="Tên Khoa" />
        <label for="name">Tên khoa</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" 
                    path="website" id="web" placeholder="Website" />
        <label for="name">Website</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:textarea  rows="10" cols="148"
                        path="gioiThieu" id="gioiThieu" placeholder="Giới thiệu Khoa" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:textarea  rows="10" cols="148"
                        path="moTaCTDT" id="moTaCTDT" placeholder="Mô tả chương trình đào tạo" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" 
                    path="file" id="vid" placeholder="Video" />
        <label for="name">Video</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${faculty.idfaculty == null}">Thêm</c:when>
                <c:otherwise>Cập nhật</c:otherwise>
            </c:choose>
        </button>
    </div>

</form:form>