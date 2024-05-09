<%-- 
    Document   : Post
    Created on : Aug 31, 2023, 5:17:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-1">Tạo bài viết</h1>
<c:url value="/admin/posts" var="action" />
<form:form method="post" action="${action}" modelAttribute="post" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="idpost" />
    <form:hidden path="postImg" />

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" 
                    path="postName" id="ten" placeholder="Tên tiêu đề" />
        <label for="name">Tên tiêu đề</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:textarea  rows="10" cols="148"
                        path="postinformation" id="noidung" placeholder="Nội dung" />
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control"
                    path="file" id="postImg" name="postImg"/>
        <label for="postImg">Chọn hình</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" 
                    path="posttype" id="loai" placeholder="Loại bài đăng" />
        <label for="name">Loại</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="facultyIdfaculty" name="facultyIdfaculty" 
                     path="facultyIdfaculty">
            <c:forEach items="${faculties}" var="fa">
                <c:choose>
                    <c:when test="${fa.idfaculty == post.facultyIdfaculty.idfaculty}">
                        <option value="${fa.idfaculty}" selected>${fa.facultyname}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${fa.idfaculty}" selected>${fa.facultyname}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
        <label for="des">Khoa</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="admissionIdadmission" name="admissionIdadmission" 
                     path="admissionIdadmission">
            <c:forEach items="${admission}" var="ad">
                <c:choose>
                    <c:when test="${ad.idadmission == post.admissionIdadmission.idadmission}">
                        <option value="${ad.idadmission}" selected>${ad.typeoftraining}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${ad.idadmission}" selected>${ad.typeoftraining}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
        <label for="des">Đào tạo</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${post.idpost == null}">Thêm</c:when>
                <c:otherwise>Cập nhật</c:otherwise>
            </c:choose>
        </button>
    </div>

</form:form>