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
    <link rel="stylesheet" type="text/css" href="new/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="new/css/style.css"/>
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
            <%--<img src="pic/f1.jpg" height="400" width="1000"/>--%>
            <div class='drag-box drag-box-6'
                    <c:if test="${groupInfo.factoryDiagramPath!=''}">
                        style='background: url("${groupInfo.factoryDiagramPath}");
                        background-size: 100% 100%;
                        background-repeat: no-repeat;'
                    </c:if>
            >
                <c:forEach items="${groupAll}" var="g">
                    <div class='drag drag-6'
                         style="left: ${g.leftX}px;top: ${g.topY}px;width: 30px;height: 30px"
                         id="pic${g.deviceType}_${g.id}">
                        <img id="${g.appEui}_${g.devEui}"
                        <c:if test="${g.deviceType=='sensor'}">
                             title="报警器:${g.deviceName},阈值:${g.alertNumber}"
                             <c:if test="${g.deviceLevel==1 && 'no'.equals(g.excludeAlert)}">src="new/img/alert_y.png"</c:if>
                             <c:if test="${g.deviceLevel==2 && 'no'.equals(g.excludeAlert)}">src="new/img/alert.png"</c:if>
                             <c:if test="${g.excludeAlert=='yes'}">src="new/img/alert_g.png"</c:if>
                        </c:if>
                        <c:if test="${g.deviceType=='device'}">
                             title="传感器:${g.deviceName}" src="new/img/sensor_b.png"
                        </c:if>
                             width=30px height=30px" style="box-shadow: 0px 0px 20px #05ed0c;">
                        <c:if test="${g.deviceType=='device'}"><p><a href="${g.appEui}">趋势图</a>
                        </p></c:if>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="col-md-12">
        <div class="tile">
            <div class="tile-body">
                <table class="table table-hover table-bordered" id="sampleTable">
                    <thead>
                    <tr>
                        <th>操作</th>
                        <th>ID</th>
                        <th>设备编号</th>
                        <th>设备名称</th>
                        <th>所属单位</th>
                        <th>备注</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${deviceConfigList}" var="device" varStatus="status">
                        <tr>
                            <td><a href="dataRetrieveByAppEui?appEui=${device.appEui}">查看传感器数据</a>&nbsp;&nbsp;
                                <a href="sensorManager?groupId=${device.groupId}">查看联动设备</a>
                            </td>
                            <td>${device.appEui}</td>
                            <td>${device.devEui}</td>
                            <td>${device.deviceName}</td>
                            <td>${groupMapData.get(device.groupId).groupName}</td>
                            <td>${device.deviceComment}</td>
                            <td>${device.createTime}</td>
                            <td id="parentId_${device.parentId}">
                                <div class="btn-group btn-group-toggle" data-toggle="buttons"
                                     id="${device.id}"
                                        <c:if test="${cuser.userRole=='user'}">
                                            style="display: none"
                                        </c:if>
                                >
                                    <c:if test="${startedApp.get(device.appEui)==true}">
                                        <label class="btn btn-warning"
                                               onclick="startAndStopReceiveData(this)"
                                               id="${device.appEui}">
                                            <input type="checkbox" autocomplete="off">暂停
                                        </label>
                                    </c:if>
                                    <c:if test="${startedApp.get(device.appEui)==false}">
                                        <label class="btn btn-success"
                                               onclick="startAndStopReceiveData(this)"
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
<script src="new/js/drag.js"></script>
<!-- The javascript plugin to display page loading on top-->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $(function () {
        $("div[id^='pic']").tooltip({
                                        hide: {
                                            effect: "explode",
                                            delay: 250
                                        }
                                    });
    });
</script>
<script src="new/js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script type="text/javascript" src="new/js/plugins/chart.js"></script>
<!-- Google analytics script-->
<script type="text/javascript">

    function updateSensorStatus() {
        var ds = $("div[id^='picdevice_']")
        for (var i = 0; i < ds.length; i++) {
            var appEui = $(ds[i]).children("img").attr("id").split("_")[0]
            $.ajax({
                       type: 'POST',
                       url: "getNewData",
                       async: false,
                       data: {
                           appEui: appEui
                       },
                       success: function (data) {
                           if (data != "") {
                               var showData = "气体浓度：" + data['40003']
                                              + "；一级报警上限：" + data['40013']
                                              + "；一级报警下限：" + data['40014']
                                              + "；二级报警上限：" + data['40015']
                                              + "；二级报警下限：" + data['40016']
                                              + "；传感器温度：" + data['40013']
                                              + "；流量：" + data['40011']
                                              + "；剩余时间：" + data['40009']
                                              + "；创建时间：" + new Date()
                               $(ds[i]).children("img").attr("title", showData)
                               console.log(data)
                           }
                       }
                   });
        }
    }

    updateSensorStatus();
    setInterval(updateSensorStatus, 10000);
    $('#tooltips').click(function () {
        var self = this;
        $.pt({
                 target: self,
                 content: '好雨知时节， 当春乃发生。随风潜入夜， 润物细无声。。。'
             });
    });

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

<script>
    $(function () {
        $('.drag-box-6 .drag').each(function (node, index) {
            var cid = $(index).attr("id");
            $(this).myDrag({
                               randomPosition: false,
                               picId: cid,
                               dragEnd: function (x, y) {
                                   console.log('停止拖动了! — 坐标 x：' + x + ' y：' + y);
                                   cid = this.picId.split("_")[1]
                                   $.ajax({
                                              type: 'POST',
                                              url: "updateXY",
                                              async: false,
                                              data: {
                                                  id: cid,
                                                  leftX: x,
                                                  topY: y
                                              },
                                              success: function (data) {
                                                  console.log('success for 坐标 x：' + x + ' y：' + y);
                                              }
                                          });
                               }
                           });
        });
    });
</script>
</body>
</html>