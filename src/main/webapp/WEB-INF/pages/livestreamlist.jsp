<%-- 
    Document   : livestreamlist
    Created on : Sep 29, 2023, 6:09:05 PM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <h2 class="card-title text-primary text-center fw-bold mb-4">CÁC LỊCH LIVESTREAM</h2>
    <div class="row">
        <c:forEach items="${livestreams}" var="ds">
           <div class="col-md-6">
                    <div class="card mb-4">
                        <div class="card-body">
                            <img src="${ds.picture}" width="120px" height="90px" class="rounded-4 float-left display-inline-block mr-3"/>
                            <a class="nav-item mt-3 " href="<c:url value='/livestreamdetail/${ds.idlivestreams}'/>" style="text-decoration: none; ">
                                <h3 class="nav-link mt-3 text-danger fw-bold"><img src="https://tuyensinh.ou.edu.vn/theme/ts2020/assets/images/icon-new.gif" style="width:48px;height:24px;">${ds.title}</h3>
                            </a>
                            <p>Time: ${ds.startTime} đến ${ds.endTime}</p>
                        </div>
                    </div>
                </div>
        </c:forEach>
    </div>
</section>
<script src="<c:url value="/assets/js/main1.js" />"></script>
