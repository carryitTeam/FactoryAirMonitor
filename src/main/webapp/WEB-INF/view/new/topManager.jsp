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
          content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>Vali Admin - Free Bootstrap 4 Admin Template</title>
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
            <h1><i class="fa fa-share-alt"></i> 拓扑管理</h1>
            <p>工厂设备拓扑结构</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-share-alt"></i></li>
            <li class="breadcrumb-item"><a href="#">拓扑管理</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <img src="/pic/f1.jpg" height="400" width="1000"/>
        </div>

        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                        <tr>
                            <th>查看数据</th>
                            <th>AppEui</th>
                            <th>DevEui</th>
                            <th>传感器名</th>
                            <th>所属单位</th>
                            <th>所属设备</th>
                            <th>备注</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sensorConfigList}" var="device" varStatus="status">
                            <tr>
                                <td><a href="/dataRetrieveByAppEui?appEui=${device.appEui}">查看</a></td>
                                <td>${device.appEui}</td>
                                <td>${device.devEui}</td>
                                <td>${device.deviceName}</td>
                                <td>${groupMapData.get(deviceDataMap.get(device.parentId).groupId).groupName}</td>
                                <td>${deviceDataMap.get(device.parentId).deviceName}</td>
                                <td>${device.deviceComment}</td>
                                <td>${device.createTime}</td>
                                <td id="parentId_${device.parentId}">
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons" id="${device.id}">
                                        <c:if test="${startedApp.get(device.appEui)==true}">
                                            <label class="btn btn-warning" onclick="startAndStopReceiveData(this)"
                                                   id="${device.appEui}">
                                                <input type="checkbox" autocomplete="off">暂停
                                            </label>
                                        </c:if>
                                        <c:if test="${startedApp.get(device.appEui)==false}">
                                            <label class="btn btn-success" onclick="startAndStopReceiveData(this)"
                                                   id="${device.appEui}">
                                                <input type="checkbox" autocomplete="off">启动
                                            </label>
                                        </c:if>
                                    </div>
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
<!-- Page specific javascripts-->
<script type="text/javascript" src="new/js/plugins/chart.js"></script>
<!-- Google analytics script-->
<script type="text/javascript">
    function startAndStopReceiveData(node) {
        var appEui = $(node).attr("id");
        var currStatus = transferString($(node).text());
        if (currStatus == '启动') {
            $.ajax({
                type: 'POST',
                url: "startReceiveData",
                async: false,
                data: {
                    appEui: appEui
                },
                success: function (data) {
                    if (data == "1") {
                        $(node).text("暂停");
                        $(node).attr("class", "btn btn-warning")
                        alert("该appEui启动成功...")
                    } else if (data == 2) {
                        alert("该appEui已启动...")
                    } else if (data == 3) {
                        alert("该appEui注册失败")
                    }
                }
            });
        } else if (currStatus == '暂停') {
            $.ajax({
                type: 'POST',
                url: "stopReceiveData",
                async: false,
                data: {
                    appEui: appEui
                },
                success: function (data) {
                    if (data == "1") {
                        $(node).text("启动");
                        $(node).attr("class", "btn btn-success")
                        alert("该appEui停止成功...")
                    } else if (data == 2) {
                        alert("该appEui已停止...")
                    }
                }
            });
        }
    }

    //替换所有的回车换行
    function transferString(content) {
        var string = content;
        try {
            string = string.replace(/\r\n/g, "")
            string = string.replace(/\n/g, "");
            string = string.replace(/\s+/g, "")
        } catch (e) {
            alert(e.message);
        }
        return string;
    }
</script>
</body>
</html>