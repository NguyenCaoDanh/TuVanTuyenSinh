<%-- 
    Document   : livestreamdetail
    Created on : Sep 29, 2023, 6:09:24 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card mb-4">
    <section class="container">
        <h2 class="card-title text-primary text-center fw-bold mb-4 mt-3">${livestream.title}</h2>
        <h5 class="text-sm-right font-weight-bold" style="text-decoration: none; color: black;">Thông báo livestream</h5>
        <h5 class="text-sm-right font-weight-bold" style="text-decoration: none; color: black;">${livestream.createdDate}</h5>
        <p style="text-align: left"><span style="color:#0000ff; font-size:22px"><strong>Nội Dung</strong></span></p>
        <p class="card-text mt-4 ">${livestream.livestreaminfomation}</p>
        <div class="d-flex justify-content-center">
            <img src="${livestream.picture}" width="560px" height="315px" />
        </div>
        <p style="text-align: left"><span style="color:#0000ff; font-size:22px"><strong>Livestream</strong></span></p>

        <div class="container col-12 text-center">
            <iframe width="560" height="315" src="${livestream.linkstream}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        </div>
        <p class="text-justify">Thời gian bắt đầu: ${livestream.startTime}</p>
        <p class="text-justify">Thời gian kết thúc: ${livestream.endTime}</p>
        <h5 class="text-sm-right font-weight-bold" style="text-decoration: none; color: black;">Tác giả: ${livestream.usersIdusers.username}</h5>
    </section>
</div>
<script src="<c:url value="/assets/js/main1.js" />"></script>