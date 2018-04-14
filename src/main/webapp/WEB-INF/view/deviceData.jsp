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
        <button id="addRelateDev" class="btn btn-info" data-toggle="modal" onclick="addRelateDev()">添加联动设备</button><label>当前用户联动设备：</label>
        <div class="table-responsive">
            <table id="alertRulesTable" cellpadding="4" cellspacing="0"
                   class="table table-bordered table-striped text-nowrap">
                <thead>
                <tr>
                    <th data-field="devEui">devEui</th>
                    <th data-field="appEui">level</th>
                    <th data-field="appEui">devEuiRelate</th>
                    <th data-field="appEui">relateNames</th>
                    <th data-field="appEui">status</th>
                    <th data-field="appEui">createTime</th>
                    <th data-field="appEui">operator</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${devEuiAlarms}" var="de">
                    <tr>
                        <td>${de.devEui}</td>
                        <td>${de.level}</td>
                        <td>${de.devEuiRelate}</td>
                        <td>${de.relateNames}</td>
                        <td>${de.status}</td>
                        <td>${de.createTime}</td>
                        <td>
                            <a href="#" class="glyphicon glyphicon-edit" title="修改" onclick="editRelateDev(this);"></a>
                            <a href="#" class="glyphicon glyphicon-remove" title="删除" onclick="delRelateDev();"></a>
                        </td>
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
                    <th data-field="createTime">createTime</th>
                    <th data-field="appEui">appEui</th>
                    <th data-field="devEui">devEui</th>
                    <th data-field="faultContect">faultContect</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${frs}" var="fr">
                    <tr>
                        <td>${fr.createTime}</td>
                        <td>${fr.appEui}</td>
                        <td>${fr.devEui}</td>
                        <td>${fr.faultContent}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 680px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">联动设备</h4>
            </div>
            <div class="modal-body">
                <div style="padding: 10px 16px 10px;">
                    <form class="bs-example bs-example-form" role="form" id="submitAlarm" action="/addRelate" method="post">
                        <div class="input-group">
                            <span class="input-group-addon">devEui</span>
                            <input type="text" class="form-control" placeholder="devEui" id="form-devEui" name="devEui">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">level</span>
                            <input type="text" class="form-control" placeholder="1,2,3，..." id="form-level" name="level">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">devEuiRelate</span>
                            <input type="text" class="form-control" placeholder="devEuiRelate" id="form-devEuiRelate" name="devEuiRelate">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">relateNames</span>
                            <input type="text" class="form-control" placeholder="relateNames" id="form-relateNames" name="relateNames">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">status</span>
                            <input type="text" class="form-control" placeholder="status" id="form-status" name="status">
                        </div>
                        <br/>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitAlarm()" id="save" data-dismiss="modal">Save</button>
            </div>
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

    function addRelateDev() {
        $("#myModal").modal({
            backdrop: 'static',
            keyboard: false
        });
    }

    function submitAlarm() {
        // document.getElementById('submitAlarm').submit();

        var status = $("#form-status").val()
        var relateNames = $("#form-relateNames").val()
        var devEuiRelate = $("#form-devEuiRelate").val()
        var level = $("#form-level").val()
        var devEui = $("#form-devEui").val()
        $.ajax({
            type: 'POST',
            url: "/addRelate",
            async: false,
            data: {
                devEui: devEui,
                level: level,
                devEuiRelate: devEuiRelate,
                relateNames: relateNames,
                status: status
            },
            success: function (data) {
                if(data=="1"){
                    alert("添加成功")
                    var aName = $("li[class='active']").children().attr('name')
                    $("#selectData").val(aName)
                    document.getElementById('tagClick').submit();
                }else {
                    alert("添加失败")
                }
            }
        });
    }

</script>
</body>
</html>
