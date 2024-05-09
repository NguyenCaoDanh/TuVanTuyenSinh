<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <h1 class="text-center text-info mt-1">QUẢN LÝ LIVESTREAM</h1>
    <section class="container">
        <div class="text-right mb-3">
            <a href="<c:url value='/admin/livestreams' />" class="btn btn-info">Đăng bài</a>
        </div>
        <div class="text-right mb-3 " small-search-box>
            <input type="text" id="searchInput" class="form-control" name ="kw" placeholder="Tìm kiếm...">
            <button class="btn btn-info" onclick="searchPosts()">Tìm kiếm</button>
        </div>
    </section>

    <c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="<c:url value="/livestreams/" />">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/livestreams/" var="pageUrl">
                        <c:param name="page" value="${i}"></c:param>
                    </c:url>
                <li class="page-item"><a class="page-link" onclick="reload()" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Tiêu đề</th>
                <th>Tác Giả</th>
                <th>Start Time</th>
                <th>End Time</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${livestreams}" var="ds">
                <tr>
                    <td>${ds.idlivestreams}</td>
                    <td>${ds.title}</td>
                    <td>${ds.usersIdusers.firstName} ${ds.usersIdusers.lastName}</td>
                    <td>${ds.startTime}</td>
                    <td>${ds.endTime}</td>
                    <td>
                        <c:url value="/api/livestreams/${ds.idlivestreams}" var="apiDel" />
                        <a href="<c:url value="/admin/livestreams/${ds.idlivestreams}" />" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="delPost('${apiDel}', ${ds.idlivestreams})">Xóa</button>
                    </td>
                </tr>   
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/assets/js/main1.js" />"></script>