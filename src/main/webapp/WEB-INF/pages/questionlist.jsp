<%-- 
    Document   : questionlist
    Created on : Sep 8, 2023, 7:02:01 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <c:if test="${counter2 > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="<c:url value="/questionlist/${post2.idpost}/" />">Tất cả</a></li>
                <c:forEach begin="1" end="${counter2}" var="i">
                    <c:url value="/questionlist/${post2.idpost}/" var="pageUrl">
                        <c:param name="page2" value="${i}"></c:param>
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>
    <h1 class="text-center text-info mt-1">${post2.postName}</h1>
    <h2 class="text-center ">Danh sách câu hỏi</h2>
    <div class="row">
        <c:forEach items="${comments}" var="dsc">
            <c:if test="${dsc.postIdpost.idpost==post2.idpost}">
                <div class="col-md-6">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="text-lg-right">${dsc.createdDate}</h5>
                            <img class="rounded-circle shadow-1-strong me-3" src="${dsc.usersIdusers.avatar}" alt="avatar" width="65" height="65" />
                            <h4>${dsc.usersIdusers.username}</h4>
                            <h4 class="text-center">Nội dung bình luận</h4>
                            <div class="card mb-4">
                                <p class="text-justify">${dsc.commentinformation}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
</section>

<script src="<c:url value="/assets/js/main1.js" />"></script>
