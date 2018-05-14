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
<!-- Navbar-->
<header class="app-header"><a class="app-header__logo" href="/">Carryit</a>
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">
        <li class="app-search">
            <h5>武汉环智净科技有限公司</h5>
        </li>
        <!-- User Menu-->
        <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i
                class="fa fa-user fa-lg"></i></a>
            <ul class="dropdown-menu settings-menu dropdown-menu-right">
                <li><a class="dropdown-item" href="page-user.html"><i class="fa fa-cog fa-lg"></i> Settings</a></li>
                <li><a class="dropdown-item" href="page-user.html"><i class="fa fa-user fa-lg"></i> Profile</a></li>
                <li><a class="dropdown-item" href="page-login.html"><i class="fa fa-sign-out fa-lg"></i> Logout</a></li>
            </ul>
        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar"
                                        src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg"
                                        alt="log">
        <div>
            <p class="app-sidebar__user-name">${cuser.userId}</p>
            <p class="app-sidebar__user-designation">${cuser.userRole}</p>
        </div>
    </div>
    <ul class="app-menu">
        <li><a class="app-menu__item" href="/checkUser"><i class="app-menu__icon fa fa-university"></i><span
                class="app-menu__label">主页</span></a></li>
        <li><a class="app-menu__item " href="/groupManager"><i
                class="app-menu__icon fa  fa-object-group"></i><span
                class="app-menu__label">单位管理</span></a></li>
        <li><a class="app-menu__item active" href="/userManager"><i class="app-menu__icon fa  fa-users"></i><span
                class="app-menu__label">账号管理</span></a></li>
        <li><a class="app-menu__item" href="/topManager"><i class="app-menu__icon fa fa-share-alt"></i><span
                class="app-menu__label">拓扑管理</span></a></li>
        <li><a class="app-menu__item" href="/alertManager"><i class="app-menu__icon fa fa-bell-o"></i><span
                class="app-menu__label">报警管理</span></a></li>
        <li><a class="app-menu__item" href="/logManager"><i class="app-menu__icon fa fa-file-text-o"></i><span
                class="app-menu__label">日志管理</span></a></li>
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i
                class="app-menu__icon fa  fa-cogs"></i><span class="app-menu__label">配置管理</span><i
                class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a class="treeview-item" href="/deviceManager"><i class="icon fa fa-circle-o"></i> 设备</a></li>
                <li><a class="treeview-item" href="/sensorManager"><i class="icon fa fa-circle-o"></i> 传感器</a></li>
            </ul>
        </li>
        <li><a class="app-menu__item" href="/faultManager"><i class="app-menu__icon fa fa-window-close-o"></i><span
                class="app-menu__label">故障管理</span></a></li>
    </ul>
</aside>
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
        if (userId == ""){
            $("#userGroup").find("option").get(0).selected=true
            $("input:radio[name='userRole']").get(0).checked=true
        }else {
            $("#userGroup").find("option[value='"+userGroupId+"']").get(0).selected=true
            $("input:radio[name='userRole'][value='"+userRole+"']").get(0).checked=true
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
        $.ajax({
            type: 'POST',
            url: "/userUpdateAndInsert",
            async: false,
            data: {
                id: id,
                userId: userId,
                userName: userName,
                userRole: userRole,
                userEmail: userEmail,
                userPwd:userPwd,
                groupId:groupId
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