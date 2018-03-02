<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">用户功能</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">数据查看</a></li>
                    <li><a href="#">报警操作</a></li>
                    <li><a href="#">设备故障</a></li>
                </ul>
                <p class="navbar-text navbar-right"><label>User: </label>${userId}</p>
            </div>
        </div>
    </div>
</nav>

</body>
</html>
