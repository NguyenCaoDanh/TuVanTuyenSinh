<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<section class="container">
    <h1 class="text-center text-info mt-1">DANH SÁCH CHUYÊN NGÀNH</h1>
    <c:if test="${user.roleUserIdRoleuser.name == 'ROLE_ADMIN'}">
        <section class="container">
            <div class="text-right mb-3">
                <a href="<c:url value='/admin/majors' />" class="btn btn-info">Thêm chuyên ngành</a>
            </div>
            <div class="text-right mb-3 " small-search-box>
                <input type="text" id="searchInput" class="form-control" name ="kw" placeholder="Tìm kiếm...">
                <button class="btn btn-info" onclick="searchPosts()">Tìm kiếm</button>
            </div> 
        </section>
    </c:if>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Mã Chuyên Ngành</th>
                <th>Chuyên Ngành</th>
                <th>Khoa</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${major}" var="ds">
                <tr>
                    <td>${ds.idmajors}</td>
                    <td>${ds.majorname}</td>
                    <td>${ds.facultyIdfaculty.facultyname}</td>        
                    <td>  
                        <c:url value="/api/major/${ds.idmajors}" var="apiDel" />
                        <a href="<c:url value="/admin/majors/${ds.idmajors}"/>" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="delPost('${apiDel}', ${ds.idmajors})">Xóa</button>
                    </td>
                </tr>   
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/assets/js/main1.js" />"></script>
