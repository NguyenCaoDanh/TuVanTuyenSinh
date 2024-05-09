<%-- 
    Document   : postlist
    Created on : Sep 5, 2023, 8:18:59 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">

    <c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="<c:url value="/postlist/${admissions.idadmission}/" />">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/postlist/${admissions.idadmission}/" var="pageUrl">
                        <c:param name="page" value="${i}"></c:param>
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>
    <h2 class="card-title text-primary text-center fw-bold mb-4">THÔNG TIN TUYỂN SINH ĐẠI HỌC ${admissions.typeoftraining}</h2>
    <div class="row">
        <c:forEach items="${posts}" var="dsp">
            <c:if test="${admissions.typeoftraining==dsp.admissionIdadmission.typeoftraining}">
                <div class="col-md-6">
                    <div class="card mb-4">
                        <div class="card-body">
                            <img src="${dsp.postImg}" width="120px" height="90px" class="rounded-4 float-left display-inline-block mr-3"/>
                            <a class="nav-item mt-3 " href="<c:url value='/postdetail/${dsp.idpost}'/>" style="text-decoration: none; ">
                                <h3 class="nav-link mt-3 text-danger fw-bold"><img src="https://tuyensinh.ou.edu.vn/theme/ts2020/assets/images/icon-new.gif" style="width:48px;height:24px;">${dsp.postName}</h3>
                            </a>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</section>

<script src="<c:url value="/assets/js/main1.js" />"></script>