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
                <a class="navbar-brand" href="/">用户功能</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#" onclick="pageSelect(this);" name="show">数据查看</a>
                    </li>
                    <li>
                        <a href="#" onclick="pageSelect(this);" name="alert">报警操作</a>
                    <li class="active">
                        <a href="#" onclick="pageSelect(this);" name="device">设备故障</a>
                    </li>
                </ul>
                <p class="navbar-text navbar-right"><label>User: </label>${user.userId}</p>
            </div>
        </div>
    </div>
</nav>
<div class="container">

    <div id="alertRules" class="row" style="min-height: 300px">
        <label>当前用户设备：</label>
        <div class="table-responsive">
            <table id="alertRulesTable" cellpadding="4" cellspacing="0"
                   class="table table-bordered table-striped text-nowrap">
                <thead>
                <tr>
                    <th data-field="ruleId">ruleId</th>
                    <th data-field="createTime">createTime</th>
                    <th data-field="changeTime">changeTime</th>
                    <th data-field="appEui">appEui</th>
                    <th data-field="devEui">devEui</th>
                    <th data-field="ruleContent">ruleContent</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${alertRules}" var="ar">
                    <tr>
                        <td>${ar.ruleId}</td>
                        <td>${ar.createTime}</td>
                        <td>${ar.changeTime}</td>
                        <td>${ar.appEui}</td>
                        <td>${ar.devEui}</td>
                        <td>${ar.ruleContent}</td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>

    </div>
    <br/>
    <div id="alertHistory" class="row" style="min-height: 500px">
        <h3>设备故障记录：</h3>
        <div class="table-responsive">
            <table id="alertHistoryTable" cellpadding="4" cellspacing="0"
                   class="table table-bordered table-striped text-nowrap">
                <thead>
                <tr>
                    <th data-field="historyId">historyId</th>
                    <th data-field="createTime">createTime</th>
                    <th data-field="changeTime">changeTime</th>
                    <th data-field="userId">userId</th>
                    <th data-field="ruleId">ruleId</th>
                    <th data-field="appEui">appEui</th>
                    <th data-field="devEui">devEui</th>
                    <th data-field="ruleContent">isProcess</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${alertHistories}" var="ah">
                    <tr>
                        <td>${ah.historyId}</td>
                        <td>${ah.createTime}</td>
                        <td>${ah.changeTime}</td>
                        <td>${ah.userId}</td>
                        <td>${ah.ruleId}</td>
                        <td>${ah.appEui}</td>
                        <td>${ah.devEui}</td>
                        <td>${ah.isProcess}</td>
                    </tr>
                    <tr>
                        <td colspan="8">
                            <pre hidden="hidden">
                                    ${ah.jsonData}
                            </pre>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


</div>
<form id='tagClick' action='/commonUser' method='post'>
    <input type='hidden' name='userId' value="${user.userId}"/>
    <input type='hidden' name='userPassword' value="${user.userPwd}"/>
    <input type='hidden' name='select' value="" id="selectData"/>
</form>
<script type="text/javascript">
    function pageSelect(node) {
        var aName = $(node).attr("name")
        $("#selectData").val(aName)
//        alert(aName)
        document.getElementById('tagClick').submit();
    }

</script>
</body>
</html>
