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
            <h1><i class="fa fa-object-group"></i> 单位管理</h1>
            <p>单位管理信息列表</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-object-group"></i></li>
            <li class="breadcrumb-item"><a href="#">单位管理</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <p class="bs-component">
                <button class="btn btn-success" type="button" onclick="startModel(this)">添加单位信息
                </button>
            </p>
        </div>
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                        <tr>
                            <th>单位名称</th>
                            <th>单位地址</th>
                            <th>联系人</th>
                            <th>联系电话</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${groupInfos}" var="groupInfo" varStatus="status">
                            <tr>
                                <td>${groupInfo.groupName}</td>
                                <td>${groupInfo.groupLocation}</td>
                                <td>${groupInfo.contactUserName}</td>
                                <td>${groupInfo.contactTelephoneNumber}</td>
                                <td>${groupInfo.createTime}</td>
                                <td>
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons"
                                         id="${groupInfo.id}">
                                            <%--<label class="btn btn-success" onclick="startModel();">--%>
                                            <%--<input type="checkbox" autocomplete="off"> 详情--%>
                                            <%--</label>--%>
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


<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true"
     id="groupManagerModel">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">单位信息</h4>
                <button type="button" class="close" data-dismiss="modal"><span
                        aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="tile-body">
                    <form class="form-horizontal">
                        <div class="form-group row">
                            <label class="control-label col-md-3">单位id号</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="用户自增长ID"
                                       id="groupId" disabled="disabled">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">单位名称</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="单位名称"
                                       id="groupName">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">单位地址</label>
                            <div class="col-md-8">
                                <textarea class="form-control" rows="2" placeholder="单位地址"
                                          id="groupLocation"></textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">联系人</label>
                            <div class="col-md-8">
                                <input class="form-control col-md-8" placeholder="联系人"
                                       id="contactUserName">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">联系电话</label>
                            <div class="col-md-8">
                                <input class="form-control col-md-8" placeholder="联系电话"
                                       id="contactTelephoneNumber">
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
        var groupId = p1.attr("id");
        var contactTelephoneNumber = p1.parent().prev().prev().text();
        var contactUserName = p1.parent().prev().prev().prev().text();
        var groupLocation = p1.parent().prev().prev().prev().prev().text();
        var groupName = p1.parent().prev().prev().prev().prev().prev().text();
        $("#groupId").val("")
        $("#groupId").val(groupId);
        $("#groupName").val("")
        $("#groupName").val(groupName);
        $("#groupLocation").val("")
        $("#groupLocation").val(groupLocation);
        $("#contactUserName").val("")
        $("#contactUserName").val(contactUserName);
        $("#contactTelephoneNumber").val("")
        $("#contactTelephoneNumber").val(contactTelephoneNumber);
    }

    function saveGroupData() {
        var groupId = $("#groupId").val();
        var groupName = $("#groupName").val();
        var groupLocation = $("#groupLocation").val();
        var contactUserName = $("#contactUserName").val();
        var contactTelephoneNumber = $("#contactTelephoneNumber").val();

        if (checkEmpty(groupName, "groupName")) {
            return true;
        }
        if (checkEmpty(groupLocation, "groupLocation")) {
            return true;
        }

        if (checkEmpty(contactUserName, "contactUserName")) {
            return true;
        }
        if (checkEmpty(contactTelephoneNumber, "contactTelephoneNumber")) {
            return true;
        }

        $.ajax({
                   type: 'POST',
                   url: "groupUpdateAndInsert",
                   async: false,
                   data: {
                       id: groupId,
                       groupName: groupName,
                       groupLocation: groupLocation,
                       contactUserName: contactUserName,
                       contactTelephoneNumber: contactTelephoneNumber
                   },
                   success: function (data) {
                       $('#groupManagerModel').modal('hide')
                       if (data == -1) {
                           alert("修改失败")
                       } else {
                           alert("修改成功")
                           window.location.href = 'groupManager';
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