<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="container mt-5">
    <h1 class="card-title text-center text-info fw-bold">${faculties1.facultyname}</h1>
    <div class="card mt-3">
        <div class="card-body">
            <h6 class="font-weight-bold"><i class="far fa-newspaper"></i> Thông tin ngành - Khoa</h6>
            <p style="text-align:center"><span style="color:#0000ff; font-size:22px"><strong>Giới Thiệu Khoa ${faculties1.facultyname}</strong></span></p>
            <div class="container col-12 text-center">
                <iframe width="560" height="315" src="${faculties1.introvideo}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
            </div>
            <p style="text-align: left"><span style="color:#0000ff; font-size:22px"><strong>Giới Thiệu Chung</strong></span></p>
            <p class="card-text">${faculties1.gioiThieu}</p>
            <p style="text-align: left"><span style="color:#0000ff; font-size:22px"><strong>Mô Tả Chương Trình Đào Tạo</strong></span></p>
            <p class="card-text">${faculties1.moTaCTDT}</p>
            <p style="text-align: left"><span style="color:#0000ff; font-size:22px"><strong>Các Ngành Đào Tạo</strong></span></p>
            <c:forEach items="${majors}" var="ds">
                <c:if test="${faculties1.idfaculty==ds.facultyIdfaculty.idfaculty}">
                    <p class="card-text">${ds.majorname}</p>
                </c:if>
            </c:forEach>
            <p class="card-text text-center">
                <a href="${faculties1.website}" target="_blank" class="btn btn-danger">Truy cập Website của Khoa ${faculties1.facultyname}  </a>
            </p>
        </div>
    </div>
</section>
<!-- Include your custom JavaScript file -->
<script src="<c:url value='/assets/js/main1.js' />"></script

