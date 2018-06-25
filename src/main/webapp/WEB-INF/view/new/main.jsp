<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Twitter meta-->
    <meta charset="utf-8">
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="carryit Admin">
    <meta property="og:title" content="carryit main">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description"
          content="EI">
    <title>EI</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="new/css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="app sidebar-mini rtl">
<jsp:include page="header_left.jsp" flush="true"/>
<main class="app-content">
    <div class="app-title">
        <div>
            <h1><i class="fa fa-university"></i> 主页</h1>
            <p>单位信息列表/数据流量统计</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
            <li class="breadcrumb-item"><a href="#">主页</a></li>
        </ul>
    </div>
    <div class="row">
        <c:forEach items="${groupInfos}" var="groupInfo" varStatus="status">
            <div class="col-md-4">
                <div class="card mb-3
                    <c:if test="${status.index % 6 ==0}"> border-primary</c:if>
                    <c:if test="${status.index % 6 ==1}"> border-success</c:if>
                    <c:if test="${status.index % 6 ==2}"> border-info</c:if>
                    <c:if test="${status.index % 6 ==3}"> border-warning</c:if>
                    <c:if test="${status.index % 6 ==4}"> border-dark</c:if>
                    <c:if test="${status.index % 6 ==5}"> border-danger</c:if>
                    ">
                    <div class="card-body" style="background-color: #d6e9ea">
                        <blockquote class="card-blockquote">
                            <p>单位名称：<b>${groupInfo.groupName}</b></p>
                            <p>单位地址：<b>${groupInfo.groupLocation}</b></p>
                            <p>负责人：<b>${groupInfo.contactUserName}</b></p>
                            <p>负责电话：<b>${groupInfo.contactTelephoneNumber}</b></p>
                            <footer>
                                <cite title="设备"><a href="devicesForGroup?groupId=${groupInfo.id}">详细设备信息</a></cite>
                            </footer>
                        </blockquote>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">各单位数据流量统计</h3>
                <div class="embed-responsive embed-responsive-16by9">
                    <canvas class="embed-responsive-item" id="lineChartDemo"></canvas>
                </div>
            </div>
        </div>
    </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="new/js/jquery-3.2.1.min.js"></script>
<script src="new/js/popper.min.js"></script>
<script src="new/js/bootstrap.min.js"></script>
<script src="new/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="new/js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script type="text/javascript" src="new/js/plugins/chart.js"></script>
</body>
</html>