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
            <p>详细信息</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
            <li class="breadcrumb-item"><a href="#">主页</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">传感器设备：</div>
        <c:forEach items="${deviceConfigList}" var="device" varStatus="status">
            <div class="col-md-4">
                <div class="card mb-3
                    border-danger
                    ">
                    <div class="card-body" style="background-color: #8deaba">
                        <blockquote class="card-blockquote">
                            <p>传感器名称：<b>${device.deviceName}</b></p>
                            <p>是否屏蔽联动设备：<b>${device.excludeAlert}</b></p>
                        </blockquote>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <div class="col-md-12">联动设备：</div>
        <c:forEach items="${sensorConfigList}" var="sensor" varStatus="status">
            <div class="col-md-4">
                <div class="card mb-3
                    border-warning
                    ">
                    <div class="card-body" style="background-color: #ead078">
                        <blockquote class="card-blockquote">
                            <p>传感器名称：<b>${sensor.deviceName}</b></p>
                            <p>端口：<b>${sensor.devicePort}</b></p>
                            <p>联动报警等级：<b>${sensor.deviceLevel}</b></p>
                        </blockquote>
                    </div>
                </div>
            </div>
        </c:forEach>
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