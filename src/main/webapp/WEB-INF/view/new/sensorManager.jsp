<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <h1><i class="fa fa-circle-o"></i> 联动报警设备管理</h1>
            <p>传感器列表</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-circle-o"></i></li>
            <li class="breadcrumb-item"><a href="#">联动报警设备管理</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <p class="bs-component">
                <button class="btn btn-success" type="button" onclick="startModel(this)"
                        <c:if test="${cuser.userRole=='user'}">
                            disabled="disabled"
                        </c:if>
                >添加联动报警设备
                </button>
            </p>
        </div>
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                        <tr>
                            <th>联动报警等级</th>
                            <th>报警字段</th>
                            <th>报警阈值</th>
                            <th>设备端口</th>
                            <th>ID</th>
                            <th>设备编号</th>
                            <th>联动设备名</th>
                            <th>所属单位</th>
                            <th>所属设备</th>
                            <th>payload</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sensorConfigList}" var="device" varStatus="status">
                            <tr>
                                <td>${device.deviceLevel}</td>
                                <td>${device.alertField}</td>
                                <td>${device.alertNumber}</td>
                                <td>${device.devicePort}</td>
                                <td>${device.appEui}</td>
                                <td>${device.devEui}</td>
                                <td>${device.deviceName}</td>
                                <td>${groupMapData.get(deviceDataMap.get(device.parentId).groupId).groupName}</td>
                                <td>${deviceDataMap.get(device.parentId).deviceName}</td>
                                <td>${device.payload}</td>
                                <td>${device.createTime}</td>
                                <td id="parentId_${device.parentId}">
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons"
                                         id="${device.id}"
                                            <c:if test="${cuser.userRole=='user'}">
                                                style="display: none"
                                            </c:if>
                                    >
                                        <label class="btn btn-info" onclick="startModel(this)">
                                            <input type="checkbox" autocomplete="off"> 修改
                                        </label>
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


<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true"
     id="groupManagerModel">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">联动报警设备信息</h4>
                <button type="button" class="close" data-dismiss="modal"><span
                        aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="tile-body">
                    <form class="form-horizontal">
                        <div class="form-group row">
                            <label class="control-label col-md-3">设备id号</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="自增长ID"
                                       id="deviceId"
                                       disabled="disabled">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">设备名称</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="设备名称"
                                       id="deviceName"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">ID</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="AppEui"
                                       id="deviceAppEui"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">设备编号</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="DevEui"
                                       id="deviceDevEui"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">设备端口</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="端口"
                                       id="devicePort"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">payload</label>
                            <div class="col-md-8">
                                <textarea class="form-control" rows="2"
                                          placeholder="6B000303FF209016"
                                          id="deviceComment"></textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">报警字段</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="报警字段"
                                       id="alertField"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">报警阈值</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="报警阈值"
                                       id="alertNumber"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">联动报警等级</label>
                            <div class="col-md-8">
                                <select class="form-control" id="deviceLevel">
                                    <option value="1">一级</option>
                                    <option value="2">二级</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">所属设备</label>
                            <div class="col-md-8">
                                <select class="form-control" id="userGroup">
                                    <c:forEach items="${deviceDataMap}" var="gmd">
                                        <option value="${gmd.key}">${gmd.value.deviceName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="saveGroupData();">Save
                    changes
                </button>
            </div>

        </div>
    </div>
</div>

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
    function checkEmpty(inputVal, showStr) {
        if (inputVal.replace(/(^s*)|(s*$)/g, "").length == 0) {
            alert(showStr + '不能为空');
            return true;
        }
        return false;
    }
    $('#sampleTable').DataTable();

    function startModel(node) {
        //加载模态框
        $('#groupManagerModel').modal();
        var p1 = $(node).parent();
        var deviceId = p1.attr("id");
        var userGroupId = p1.parent().attr("id").split("_")[1]
        var deviceComment = p1.parent().prev().prev().text();
        var deviceName = p1.parent().prev().prev().prev().prev().prev().text();
        var devEui = p1.parent().prev().prev().prev().prev().prev().prev().text();
        var appEui = p1.parent().prev().prev().prev().prev().prev().prev().prev().text();
        var devicePort = p1.parent().prev().prev().prev().prev().prev().prev().prev().prev().text();
        var alertNumber = p1.parent().prev().prev().prev().prev().prev().prev().prev().prev().prev()
            .text();
        var alertField = p1.parent().prev().prev().prev().prev().prev().prev().prev().prev().prev()
            .prev().text();
        var deviceLevel = p1.parent().prev().prev().prev().prev().prev().prev().prev().prev().prev()
            .prev().prev().text();
        $("#deviceId").val("")
        $("#deviceId").val(deviceId);
        $("#deviceName").val("")
        $("#deviceName").val(deviceName);
        $("#deviceAppEui").val("")
        $("#deviceAppEui").val(appEui);
        $("#deviceDevEui").val("")
        $("#deviceDevEui").val(devEui);
        $("#deviceComment").val("")
        $("#deviceComment").val(deviceComment);
        $("#devicePort").val("")
        $("#devicePort").val(devicePort);
        $("#alertField").val("")
        $("#alertField").val(alertField);
        $("#alertNumber").val("")
        $("#alertNumber").val(alertNumber);

        if (deviceId == "") {
            $("#userGroup").find("option").get(0).selected = true
            $("#deviceLevel").find("option").get(0).selected = true
        } else {
            $("#userGroup").find("option[value='" + userGroupId + "']").get(0).selected = true
            $("#deviceLevel").find("option[value='" + deviceLevel + "']").get(0).selected = true
        }
    }

    function saveGroupData() {
        var id = $("#deviceId").val()
        var deviceName = $("#deviceName").val()
        var appEui = $("#deviceAppEui").val()
        var devEui = $("#deviceDevEui").val()
        var deviceComment = $("#deviceComment").val()
        var devicePort = $("#devicePort").val()
        var alertField = $("#alertField").val()
        var alertNumber = $("#alertNumber").val()
        var parentId = $("#userGroup").find("option:selected").attr("value");
        var deviceLevel = $("#deviceLevel").find("option:selected").attr("value");

        if (checkEmpty(deviceName, "deviceName")) {
            return true;
        }
        if (checkEmpty(appEui, "appEui")) {
            return true;
        }
        // if (checkEmpty(devEui, "devEui")) {
        //     return true;
        // }
        if (checkEmpty(devicePort, "devicePort")) {
            return true;
        }

        $.ajax({
                   type: 'POST',
                   url: "sensorUpdateAndInsert",
                   async: false,
                   data: {
                       id: id,
                       deviceName: deviceName,
                       appEui: appEui,
                       devEui: devEui,
                       payload: deviceComment,
                       parentId: parentId,
                       devicePort: devicePort,
                       deviceLevel: deviceLevel,
                       alertField: alertField,
                       alertNumber: alertNumber
                   },
                   success: function (data) {
                       $('#groupManagerModel').modal('hide')
                       if (data == -1) {
                           alert("修改失败")
                       } else {
                           alert("修改成功")
                           window.location.href = '/sensorManager';
                       }
                   }
               });
    }
</script>
</body>
</html>