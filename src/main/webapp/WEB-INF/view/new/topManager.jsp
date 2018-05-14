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
        <li><a class="app-menu__item" href="/groupManager"><i class="app-menu__icon fa  fa-object-group"></i><span
                class="app-menu__label">单位管理</span></a></li>
        <li><a class="app-menu__item" href="/userManager"><i class="app-menu__icon fa  fa-users"></i><span
                class="app-menu__label">账号管理</span></a></li>
        <li><a class="app-menu__item active" href="/topManager"><i class="app-menu__icon fa fa-share-alt"></i><span
                class="app-menu__label">拓扑管理</span></a></li>
        <li><a class="app-menu__item" href="/alertManager"><i class="app-menu__icon fa fa-bell-o"></i><span
                class="app-menu__label">报警管理</span></a></li>
        <li><a class="app-menu__item" href="/topManager"><i class="app-menu__icon fa fa-file-text-o"></i><span
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
            <img src="/pic/f1.jpg" height="400" width="1000" />
        </div>

        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                        <tr>
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
                                <td>${device.appEui}</td>
                                <td>${device.devEui}</td>
                                <td>${device.deviceName}</td>
                                <td>${groupMapData.get(deviceDataMap.get(device.parentId).groupId).groupName}</td>
                                <td>${deviceDataMap.get(device.parentId).deviceName}</td>
                                <td>${device.deviceComment}</td>
                                <td>${device.createTime}</td>
                                <td id="parentId_${device.parentId}">
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons" id="${device.id}">
                                        <label class="btn btn-success" onclick="startModel(this)">
                                            <input type="checkbox" autocomplete="off"> 启动
                                        </label>
                                        <label class="btn btn-warning" onclick="startModel(this)">
                                            <input type="checkbox" autocomplete="off"> 暂停
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
</body>
</html>