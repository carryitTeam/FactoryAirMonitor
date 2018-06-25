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
            <h1><i class="fa fa-users"></i> 用户管理</h1>
            <p>用户管理信息列表</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-users"></i></li>
            <li class="breadcrumb-item"><a href="#">用户管理</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <p class="bs-component">
                <button class="btn btn-success" type="button" onclick="startModel(this)">添加用户信息</button>
            </p>
        </div>
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                        <tr>
                            <th>用戶ID</th>
                            <th>用户Email</th>
                            <th>用户姓名</th>
                            <th>用户密码</th>
                            <th>用户角色</th>
                            <th>用户隶属单位</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userList}" var="user" varStatus="status">
                            <tr>
                                <td>${user.userId}</td>
                                <td>${user.userEmail}</td>
                                <td>${user.userName}</td>
                                <td>${user.userPwd}</td>
                                <td>${user.userRole}</td>
                                <td>${groupMapData.get(user.groupId).groupName}</td>
                                <td>${user.createTime}</td>
                                <td id="${user.groupId}">
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons" id="${user.id}">
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


<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true" id="userManagerModel">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">用户信息</h4>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="tile-body">
                    <form class="form-horizontal">
                        <div class="form-group row">
                            <label class="control-label col-md-3">用户id号</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="用户自增长ID" id="idd"
                                       disabled="disabled">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">用户ID</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="用户ID" id="userId">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">用户妮名</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="用户妮名" id="userName">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">用户Email</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="用户邮箱" id="userEmail">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">用户密码</label>
                            <div class="col-md-8">
                                <input class="form-control" type="password" placeholder="用户密码" id="userPassword">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">用户角色</label>
                            <div class="col-md-8">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="userRole" id="userRole1" value="user" checked>
                                        user
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="userRole" id="userRole2" value="admin">
                                        admin
                                    </label>
                                </div>
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
                <button type="button" class="btn btn-primary" onclick="saveUserData();">Save changes</button>
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
        $('#userManagerModel').modal();
        var p1 = $(node).parent();
        var useridd = p1.attr("id");
        var userGroupId = p1.parent().attr("id");
        var userRole = p1.parent().prev().prev().prev().text();
        var userPassword = p1.parent().prev().prev().prev().prev().text();
        var userName = p1.parent().prev().prev().prev().prev().prev().text();
        var userEmail = p1.parent().prev().prev().prev().prev().prev().prev().text();
        var userId = p1.parent().prev().prev().prev().prev().prev().prev().prev().text();
        $("#idd").val("")
        $("#idd").val(useridd);
        $("#userId").val("")
        $("#userId").val(userId);
        $("#userEmail").val("")
        $("#userEmail").val(userEmail);
        $("#userName").val("")
        $("#userName").val(userName);
        $("#userPassword").val("")
        $("#userPassword").val(userPassword);
        if (userId == "") {
            $("#userGroup").find("option").get(0).selected = true
            $("input:radio[name='userRole']").get(0).checked = true
        } else {
            $("#userGroup").find("option[value='" + userGroupId + "']").get(0).selected = true
            $("input:radio[name='userRole'][value='" + userRole + "']").get(0).checked = true
        }
    }

    function saveUserData() {
        var id = $("#idd").val();
        var groupId = $("#userGroup").find("option:selected").attr("value");
        var userRole = $("input[name='userRole']:checked").val();
        var userPwd = $("#userPassword").val();
        var userName = $("#userName").val();
        var userEmail = $("#userEmail").val();
        var userId = $("#userId").val();

        if (checkEmpty(userId, "userId")) {
            return true;
        }
        if (checkEmpty(userName, "userName")) {
            return true;
        }
        if (checkEmpty(userPwd, "userPwd")) {
            return true;
        }
        if (checkEmpty(userEmail, "userEmail")) {
            return true;
        }
        $.ajax({
            type: 'POST',
            url: "userUpdateAndInsert",
            async: false,
            data: {
                id: id,
                userId: userId,
                userName: userName,
                userRole: userRole,
                userEmail: userEmail,
                userPwd: userPwd,
                groupId: groupId
            },
            success: function (data) {
                $('#userManagerModel').modal('hide')
                if (data == -1) {
                    alert("修改失败")
                } else {
                    alert("修改成功")
                    window.location.href = '/userManager';
                }
            }
        });
    }
</script>
</body>
</html>