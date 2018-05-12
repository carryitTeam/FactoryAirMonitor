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
            <input class="app-search__input" type="search" placeholder="Search">
            <button class="app-search__button"><i class="fa fa-search"></i></button>
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
        <li><a class="app-menu__item" href="/groupManager"><i
                class="app-menu__icon fa  fa-object-group"></i><span
                class="app-menu__label">单位管理</span></a></li>
        <li><a class="app-menu__item" href="/userManager"><i class="app-menu__icon fa  fa-users"></i><span
                class="app-menu__label">账号管理</span></a></li>
        <li><a class="app-menu__item" href="/topManager"><i class="app-menu__icon fa fa-share-alt"></i><span
                class="app-menu__label">拓扑管理</span></a></li>
        <li><a class="app-menu__item active" href="/alertManager"><i class="app-menu__icon fa fa-bell-o"></i><span
                class="app-menu__label">报警管理</span></a></li>
        <li><a class="app-menu__item" href="/logManager"><i class="app-menu__icon fa fa-file-text-o"></i><span
                class="app-menu__label">日志管理</span></a></li>
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i
                class="app-menu__icon fa  fa-cogs"></i><span class="app-menu__label">配置管理</span><i
                class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a class="treeview-item" href="ui-cards.html"><i class="icon fa fa-circle-o"></i> 设备</a></li>
                <li><a class="treeview-item" href="widgets.html"><i class="icon fa fa-circle-o"></i> 传感器</a></li>
            </ul>
        </li>
        <li><a class="app-menu__item" href="/faulttManager"><i class="app-menu__icon fa fa-window-close-o"></i><span
                class="app-menu__label">故障管理</span></a></li>
    </ul>
</aside>
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
                            <th>AppEUI</th>
                            <th>DevEUI</th>
                            <th>十六进制结果</th>
                            <th>创建时间</th>
                            <th>是否处理</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${alertHistories}" var="ah" varStatus="status">
                            <tr>
                                <td>${ah.appEui}</td>
                                <td>${ah.devEui}</td>
                                <td>${careDatas.get(ah.id)}</td>
                                <td>${ah.createTime}</td>
                                <td>
                                    <c:if test="${ah.isProcess=='0'}">
                                        <button class="btn btn-small btn-info">处理</button>
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


<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true" id="groupManagerModel">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">单位信息</h4>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="tile-body">
                    <form class="form-horizontal">
                        <div class="form-group row">
                            <label class="control-label col-md-3">单位id号</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="用户自增长ID" id="groupId" disabled="disabled">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">单位名称</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" placeholder="单位名称" id="groupName">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">单位地址</label>
                            <div class="col-md-8">
                                <textarea class="form-control" rows="2" placeholder="单位地址" id="groupLocation"></textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">联系人</label>
                            <div class="col-md-8">
                                <input class="form-control col-md-8" placeholder="联系人" id="contactUserName">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">联系电话</label>
                            <div class="col-md-8">
                                <input class="form-control col-md-8"  placeholder="联系电话" id="contactTelephoneNumber">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="saveGroupData();">Save changes</button>
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
        $.ajax({
            type: 'POST',
            url: "/groupUpdateAndInsert",
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
                    window.location.href='/groupManager';
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