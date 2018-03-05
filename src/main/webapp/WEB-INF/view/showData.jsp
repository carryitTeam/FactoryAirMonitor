<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-table.js"></script>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-table.css" rel="stylesheet">
    <link href="css/jquery.json-viewer.css" type="text/css" rel="stylesheet"/>
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
                    <li class="active">
                        <a href="#" onclick="pageSelect(this);" name="show">数据查看</a>
                    </li>
                    <li>
                        <a href="#" onclick="pageSelect(this);" name="alert">报警操作</a>
                    <li>
                        <a href="#" onclick="pageSelect(this);" name="device">设备故障</a>
                    </li>
                </ul>
                <p class="navbar-text navbar-right"><label>User: </label>${user.userId}</p>
            </div>
        </div>
    </div>
</nav>
<div class="container">
    <pre id="result">
    </pre>
    <div class="table-responsive">
        <table id="table" cellpadding="4" cellspacing="0" class="table table-bordered table-striped text-nowrap">
            <thead>
            <tr>
                <th data-field="all">all</th>
                <th data-field="appEui">appEui</th>
                <th data-field="devEui">devEui</th>
                <th data-field="realData">realData</th>
                <%--<th data-field="jsonData">jsonData</th>--%>
                <th data-field="createTime">createTime</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="dl" items="${datasList}">
                <tr>
                    <td><a onclick="showAll(this)">all</a>
                        <p hidden="hidden">${dl.jsonData}</p></td>
                    <td>${dl.appEui}</td>
                    <td>${dl.devEui}</td>
                    <td>${dl.realData}</td>
                        <%--<td>${dl.jsonData}</td>--%>
                    <td>${dl.createTime}</td>
                </tr>
                <tr hidden="hidden">
                    <td colspan=5>
                       <pre name="fullData">
                               ${dl.jsonData}
                       </pre>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
<form id='tagClick' action='/commonUser' method='post'>
    <input type='hidden' name='userId' value="${user.userId}"/>
    <input type='hidden' name='userPassword' value="${user.userPwd}"/>
    <input type='hidden' name='select' value="" id="selectData"/>
</form>
<script src="js/jquery.json-viewer.js"></script>
<script type="text/javascript">

    $(document).ready(function () {
        var fullDatas = $("pre[name='fullData']");
        for (var i = 0; i < fullDatas.length; i++) {
            var options = {
                collapsed: false,
                withQuotes: false
            };
            var tdt = $(fullDatas.get(i)).text()
            var input = eval('(' + tdt + ')');
            $(fullDatas.get(i)).text("")
            $(fullDatas.get(i)).jsonViewer(input, options);
            $(fullDatas.get(i)).hide()
        }
    });


    function showAll(node) {
        $(node).parent().parent().after().children("pre").show()
    }

    function pageSelect(node) {
        var aName = $(node).attr("name")
        $("#selectData").val(aName)
//        alert(aName)
        document.getElementById('tagClick').submit();
    }

    var $table = $('#table');
    $(function () {
        $table.bootstrapTable({});
    });
</script>

</body>
</html>
