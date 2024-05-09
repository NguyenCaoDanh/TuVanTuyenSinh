<%-- 
    Document   : major
    Created on : Sep 29, 2023, 1:07:30 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info mt-1">Chuyên Ngành Đào Tạo</h1>
<c:url value="/admin/majors" var="action" />
<form:form method="post" action="${action}" modelAttribute="major" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="idmajors" />
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
        <form:input type="text" class="form-control" 
                    path="majorname" id="majorname" placeholder="Tên chuyên ngành" />
        <label for="name">Tên chuyên ngành</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${major.idmajors == null}">Thêm</c:when>
                <c:otherwise>Cập nhật</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
