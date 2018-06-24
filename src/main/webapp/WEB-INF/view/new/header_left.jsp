<%--
  Created by IntelliJ IDEA.
  User: hlzou
  Date: 2018/5/15
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header class="app-header"><a class="app-header__logo" href="/">Ei</a>
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
                <%--<li><a class="dropdown-item" href="page-user.html"><i class="fa fa-cog fa-lg"></i> Settings</a></li>--%>
                <%--<li><a class="dropdown-item" href="page-user.html"><i class="fa fa-user fa-lg"></i> Profile</a></li>--%>
                <li><a class="dropdown-item" href="/logOut"><i class="fa fa-sign-out fa-lg"></i> Logout</a></li>
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
<c:if test="${cuser.userRole=='superAdmin'}">
        <li><a class="app-menu__item
        <c:if test="${fn:contains(pageContext.request.requestURI,'main')||
        fn:contains(pageContext.request.requestURI,'detailDataInfo')||
        fn:contains(pageContext.request.requestURI,'detailData')||
        fn:contains(pageContext.request.requestURI,'detailSenorData')}">
            active
        </c:if>
        " href="/checkUser"><i class="app-menu__icon fa fa-university"></i><span
                class="app-menu__label">主页</span></a></li>
</c:if>
        <c:if test="${cuser.userRole=='superAdmin'}">
            <li><a class="app-menu__item
<c:if test="${fn:contains(pageContext.request.requestURI,'groupManager')}">
            active
        </c:if>" href="/groupManager"><i class="app-menu__icon fa  fa-object-group"></i><span
                    class="app-menu__label">单位管理</span></a></li>
        </c:if>
        <c:if test="${cuser.userRole!='user'}">
            <li><a class="app-menu__item
<c:if test="${fn:contains(pageContext.request.requestURI,'userManager')}">
            active
        </c:if>" href="/userManager"><i class="app-menu__icon fa  fa-users"></i><span
                    class="app-menu__label">账号管理</span></a></li>
        </c:if>
        <li><a class="app-menu__item
<c:if test="${fn:contains(pageContext.request.requestURI,'topManager')}">
            active
        </c:if>" href="/topManager"><i class="app-menu__icon fa fa-share-alt"></i><span
                class="app-menu__label">拓扑管理</span></a></li>
        <li><a class="app-menu__item
<c:if test="${fn:contains(pageContext.request.requestURI,'alertManager')}">
            active
        </c:if>" href="/alertManager"><i class="app-menu__icon fa fa-bell-o"></i><span
                class="app-menu__label">报警管理</span></a></li>
        <li><a class="app-menu__item
<c:if test="${fn:contains(pageContext.request.requestURI,'logManager')}">
            active
        </c:if>" href="/logManager"><i class="app-menu__icon fa fa-file-text-o"></i><span
                class="app-menu__label">日志管理</span></a></li>
        <li class="treeview
<c:if test="${fn:contains(pageContext.request.requestURI,'deviceManager')||fn:contains(pageContext.request.requestURI,'sensorManager')}">
            is-expanded
        </c:if>
"><a class="app-menu__item" href="#" data-toggle="treeview"><i
                class="app-menu__icon fa  fa-cogs"></i><span class="app-menu__label">配置管理</span><i
                class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a class="treeview-item
<c:if test="${fn:contains(pageContext.request.requestURI,'deviceManager')}">
            active
        </c:if>" href="/deviceManager"><i class="icon fa fa-circle-o"></i> 数据传感设备</a></li>
                <li><a class="treeview-item
<c:if test="${fn:contains(pageContext.request.requestURI,'sensorManager')}">
            active
        </c:if>" href="/sensorManager"><i class="icon fa fa-circle-o"></i> 联动报警设备</a></li>
            </ul>
        </li>
        <li><a class="app-menu__item
<c:if test="${fn:contains(pageContext.request.requestURI,'faultManager')}">
            active
        </c:if>" href="/faultManager"><i class="app-menu__icon fa fa-window-close-o"></i><span
                class="app-menu__label">故障管理</span></a></li>
    </ul>
</aside>

</body>
</html>
