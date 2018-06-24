a
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Twitter meta-->
    <meta charset="utf-8">
    <meta http-equiv="refresh" content="20">
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
            <li class="breadcrumb-item"><a href="/checkUser">主页</a></li>
            <%--<li class="breadcrumb-item"><a href="/devicesForGroup?groupId=${deviceConfigList.size()>0 ? deviceConfigList.get(0).groupId:0}">设备列表</a></li>--%>
            <li class="breadcrumb-item"><a
                    href="/dataRetrieveByAppEui?appEui=${datasList.size()>0 ? datasList.get(0).appEui:0}">传感器数据</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-6">
            <c:if test="${startedApp.get(datasList.get(0).appEui)==true}">
                <p class="text-success">AppEui:${datasList.get(0).appEui}启动状态</p>
            </c:if>
            <c:if test="${startedApp.get(datasList.get(0).appEui)==false}">
                <p class="text-danger">AppEui:${datasList.get(0).appEui}暂停状态</p>
            </c:if>
        </div>
        <div class="col-md-6">
            <marquee>
                <span style="font-weight: bolder;font-size: 20px;color: red;">数据自动刷新时间为：20s</span>
            </marquee>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                        <tr>
                            <th>AppEui</th>
                            <th>DevEui</th>
                            <th>十六进制结果</th>
                            <th>创建时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${datasList}" var="dl" varStatus="status">
                            <tr>
                                <td>${dl.appEui}</td>
                                <td>${dl.devEui}</td>
                                <td>${parseData.get(dl.id)}</td>
                                <td>${dl.createTime}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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
<script type="text/javascript">
    $('#sampleTable').DataTable();
</script>
</body>
</html>