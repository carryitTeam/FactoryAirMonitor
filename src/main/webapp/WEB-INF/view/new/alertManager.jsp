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
            <h1><i class="fa fa-bell-o"></i> 报警管理</h1>
            <p>报警管理信息列表</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-bell-o"></i></li>
            <li class="breadcrumb-item"><a href="#">报警管理</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                        <tr>
                            <th>报警级别</th>
                            <th>报警id</th>
                            <th>AppEUI(ID)</th>
                            <th>DevEUI(设备编号)</th>
                            <th>十六进制结果</th>
                            <th>创建时间</th>
                            <th>是否处理</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${alertHistories}" var="ah" varStatus="status">
                            <tr>
                                <td>${ah.faultContect}</td>
                                <td>${ah.historyId}</td>
                                <td>${ah.appEui}</td>
                                <td>${ah.devEui}</td>
                                <td>${careDatas.get(ah.id)}</td>
                                <td>${ah.createTime}</td>
                                <td>
                                    <c:if test="${ah.isProcess=='0'}">
                                        <button class="btn btn-small btn-info"
                                                onclick="dealAlert(this)">处理
                                        </button>
                                    </c:if>
                                    <c:if test="${ah.isProcess!='0'}">
                                        <button class="btn btn-small btn-warning">已处理</button>
                                    </c:if>
                                </td>
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
<script type="text/javascript" src="new/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="new/js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">

    function dealAlert(node) {
        var appEui = $(node).parent().prev().prev().prev().prev().text();
        var alertId = $(node).parent().prev().prev().prev().prev().prev().text();
        $.ajax({
                   type: 'POST',
                   url: "dealAlert",
                   async: false,
                   data: {
                       appEui: appEui,
                       alertId: alertId
                   },
                   success: function (data) {
                       if (data == 0) {
                           alert("处理失败")
                       } else if (data == -1) {
                           alert("appEui未Join启动")
                       } else {
                           alert("处理成功，处理了 " + data + " 个联动设备")
                           $(node).text("已处理完")
                           $(node).attr("disabled", "disabled")
                       }
                   }
               });
    }
</script>
</body>
</html>