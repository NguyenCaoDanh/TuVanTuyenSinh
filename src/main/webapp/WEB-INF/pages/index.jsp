<%-- 
    Document   : index
    Created on : Jul 29, 2023, 7:47:55 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    .section_subs {
        background-color: black;
        padding: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    }

    .section_subs * {
        color: white;
    }
    select.browser-default.custom-select{
        color: black;
    }
    select.browser-default.custom-select option {
        color: black;
    }
</style>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div id="bannerCarousel" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <c:forEach items="${banner}" var="dsb" varStatus="status">
                        <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                            <img src="${dsb.image}" alt="Banner Image" class="d-block w-100 border-light">
                        </div>
                    </c:forEach>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#bannerCarousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#bannerCarousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
</div>


<c:forEach items="${admission}" var="ds" >  
    <div class="container my-5">
        <h2 class="card-title text-primary text-center fw-bold mb-4" id="${ds.idadmission}">THÔNG TIN TUYỂN SINH ĐẠI HỌC ${ds.typeoftraining}</h2>
        <div class="row">
            <c:set var="postCount" value="0" />
            <c:forEach items="${posts}" var="dsp" varStatus="loopStatus">
                <c:if test="${ds.typeoftraining eq dsp.admissionIdadmission.typeoftraining && postCount lt 5}">
                    <div class="col-md-6">
                        <div class="card mb-4">
                            <div class="card-body">
                                <img src="${dsp.postImg}" width="120px" height="90px" class="rounded-4 float-left display-inline-block mr-3"/>
                                <a class="nav-item mt-3 " href="<c:url value='/postdetail/${dsp.idpost}'/>" style="text-decoration: none; ">
                                    <h3 class="nav-link mt-3 text-danger fw-bold"><img src="https://tuyensinh.ou.edu.vn/theme/ts2020/assets/images/icon-new.gif" style="width:48px;height:24px;"> ${dsp.postName}</h3>
                                </a>
                            </div>
                        </div>
                    </div>
                    <c:set var="postCount" value="${postCount + 1}" />
                </c:if>
            </c:forEach>
            <a class="float-right"href="<c:url value='/postlist/${ds.idadmission}/'/>">
                <h6 class="float-right">Xem thêm >></h6>
            </a>
        </div>
    </div>
</c:forEach>
<section class="p-5 align-self-center section_subs bg-primary">
    <div class="container">
        <div class="col-md-12 m-pad-subs">
            <div id="w-4_container">
                <div id="w-4">
                    <div class="rendered-form ">
                        <div class="">
                            <h1 class="text-center section_subs_title fw-bold" id="control-849089">
                                CÂU HỎI TUYỂN SINH<br>
                            </h1>
                        </div>
                        <c:url value="/questionnow/" var="action" />
                        <form:form method="post" action="${action}" modelAttribute="QModel" enctype="multipart/form-data">
                            <div class="fb-text form-group field-hoten">
                                <label for="hoten" class="fb-text-label">Họ tên:<br></label>
                                    <form:input type="text" class="form-control" 
                                                path="hoTen" id="ten" maxlength="100"/>
                               
                            </div>
                            <div class="fb-text form-group field-email">
                                <label for="hoten" class="fb-text-label">Email:<br></label>
                                    <form:input type="text" class="form-control" 
                                                path="Email" id="email" maxlength="100" />
                                
                            </div>
                            <div class="fb-text form-group field-dienthoai">
                                <label for="hoten" class="fb-text-label">Điện thoại:<br></label>
                                    <form:input type="text" class="form-control" 
                                                path="sdt" id="ten" maxlength="100" />
                            
                            </div>
                            <div class="fb-textarea form-group field-textarea-1581500170575">
                                <label for="hoten" class="fb-text-label">Câu hỏi:<br></label>
                                    <form:input type="text" class="form-control" 
                                                path="cauHoi" id="ten" maxlength="100"/>
                            </div>
                            <div class="fb-select form-group field-hedt">
                                <label class="fb-select-label">Hệ đào tạo:<br></label>
                                    <form:select class="browser-default custom-select" id="heDaoTao" name="heDaoTao" 
                                                 path="heDaoTao">
                                        <c:forEach items="${admission}" var="ds">
                                        <option value="${ds.typeoftraining}">${ds.typeoftraining}</option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="form-floating mb-3 mt-3">
                                <button class="btn btn-info" type="submit">
                                    Đăng ký nhận thông tin
                                </button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="<c:url value="/assets/js/banner.js" />"></script>
