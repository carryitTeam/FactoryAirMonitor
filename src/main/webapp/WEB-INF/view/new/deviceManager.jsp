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
            <h1><i class="fa fa-circle-o"></i> 数据传感设备管理</h1>
            <p>设备列表</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-circle-o"></i></li>
            <li class="breadcrumb-item"><a href="#">数据传感设备管理</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <p class="bs-component">
                <button class="btn btn-success" type="button" onclick="startModel(this)"
                        <c:if test="${cuser.userRole=='user'}">
                            disabled="disabled"
                        </c:if>
                >添加数据传感设备
                </button>
            </p>
        </div>
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>设备编号</th>
                            <th>设备名</th>
                            <th>所属单位</th>
                            <th>备注</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${deviceConfigList}" var="device" varStatus="status">
                            <tr>
                                <td>${device.appEui}</td>
                                <td>${device.devEui}</td>
                                <td>${device.deviceName}</td>
                                <td>${groupMapData.get(device.groupId).groupName}</td>
                                <td>${device.deviceComment}</td>
                                <td>${device.createTime}</td>
                                <td id="${device.groupId}">
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons" id="${device.id}"
                                            <c:if test="${cuser.userRole=='user'}">
                                                style="display: none"
                                            </c:if>
                                    >
                                        <label class="btn btn-info" onclick="startModel(this);">
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


<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true" id="groupManagerModel">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">设备信息</h4>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="tile-body">
                    <form class="form-horizontal" id="deviceForm">
                        <div class="form-group row">
                            <label class="control-label col-md-3">设备id号</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="自增长ID" id="deviceId"
                                       disabled="disabled">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">设备名称</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="设备名称" id="deviceName"
                                       required="required">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">ID</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="AppEui" id="deviceAppEui"
                                       required="required">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">设备编号</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="DevEui" id="deviceDevEui"
                                       required="required">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">备注</label>
                            <div class="col-md-8">
                                <textarea class="form-control" rows="2" placeholder="备注"
                                          id="deviceComment"></textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">隶属单位</label>
                            <div class="col-md-8">
                                <select class="form-control" id="userGroup">
                                    <c:forEach items="${groupMapData}" var="gmd">
                                        <option value="${gmd.key}">${gmd.value.groupName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="return saveGroupData();">Save changes</button>
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
        var userGroupId = p1.parent().attr("id");
        var deviceComment = p1.parent().prev().prev().text();
        var deviceName = p1.parent().prev().prev().prev().prev().text();
        var devEui = p1.parent().prev().prev().prev().prev().prev().text();
        var appEui = p1.parent().prev().prev().prev().prev().prev().prev().text();
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

        if (deviceId == "") {
            $("#userGroup").find("option").get(0).selected = true
        } else {
            $("#userGroup").find("option[value='" + userGroupId + "']").get(0).selected = true
        }
    }

    function saveGroupData() {
        var id = $("#deviceId").val()
        var deviceName = $("#deviceName").val()
        var appEui = $("#deviceAppEui").val()
        var devEui = $("#deviceDevEui").val()
        var deviceComment = $("#deviceComment").val()
        var groupId = $("#userGroup").find("option:selected").attr("value");

        if (checkEmpty(deviceName, "deviceName")) {
            return true;
        }
        if (checkEmpty(appEui, "appEui")) {
            return true;
        }
        if (checkEmpty(devEui, "devEui")) {
            return true;
        }

        $.ajax({
            type: 'POST',
            url: "/deviceUpdateAndInsert",
            async: false,
            data: {
                id: id,
                deviceName: deviceName,
                appEui: appEui,
                devEui: devEui,
                deviceComment: deviceComment,
                groupId: groupId
            },
            success: function (data) {
                $('#groupManagerModel').modal('hide')
                if (data == -1) {
                    alert("修改失败")
                } else {
                    alert("修改成功")
                    window.location.href = '/deviceManager';
                }
            }
        });
    }
</script>
<!-- Google analytics script-->
<script type="text/javascript">
    if (document.location.hostname == 'pratikborsadiya.in') {
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o),
                m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
        ga('create', 'UA-72504830-1', 'auto');
        ga('send', 'pageview');
    }
</script>
</body>
</html>