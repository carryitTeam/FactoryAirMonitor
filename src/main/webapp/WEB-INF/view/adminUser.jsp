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
                <a class="navbar-brand" href="#">管理员操作</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">用户管理</a></li>
                </ul>
                <p class="navbar-text navbar-right"><label>User: </label>${userId}</p>
            </div>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-lg-2">
            <%--<button id="addUser" class="btn btn-info" data-toggle="modal" data-target="#myModal">添加新用户</button>--%>
            <button id="addUser" class="btn btn-info" data-toggle="modal" onclick="addUser();">添加新用户</button>
            <label>用户列表: </label></div>
        <div class="col-lg-2"></div>
        <div class="col-lg-8"></div>
    </div>
    <br/>
    <table class="table table-bordered">
        <tr>
            <th>status</th>
            <th>userId</th>
            <th>userName</th>
            <th>userPwd</th>
            <th>userEmail</th>
            <th>userRole</th>
            <th>appEui</th>
            <th>changeTime</th>
            <th>createTime</th>
            <th>operator</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <c:set var="dog" scope="page" value="${user.id}${'_'}${user.appEui}"/>
            <c:if test="${userData[dog]==true}">
                <tr style="background: #79ff0a;" id="${user.id}">
                <td><span class="glyphicon glyphicon-off" style="color: rgb(0, 129, 0);">On</span>
                </td>
            </c:if>
            <c:if test="${userData[dog]==false}">
                <tr style="background: #fff3b5;" id="${user.userId}">
                <td><span class="glyphicon glyphicon-off" style="color: rgb(255, 0, 0);">Off</span>
                </td>
            </c:if>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.userPwd}</td>
            <td>${user.userEmail}</td>
            <td>${user.userRole}</td>
            <td>${user.appEui}</td>
            <td>${user.changeTime}</td>
            <td>${user.createTime}</td>
            <td>
                <a href="#" class="glyphicon glyphicon-edit" title="修改" onclick="editUser(this);"></a>
                <a href="#" class="glyphicon glyphicon-remove" title="删除" onclick="delUser();"></a>
                <c:if test="${user.userRole!='admin'}">
                    <a href="#" class="glyphicon glyphicon-play" title="开始获取数据" onclick="startReceiveData(this);"></a>
                    <a href="#" class="glyphicon glyphicon-stop" title="停止获取数据" onclick="stopReceiveData(this);"></a>

                    <form id="_form" method="post" action="/commonUser">
                        <input type="hidden" id="userId" value="${user.userId}"/>
                        <input type="hidden" id="userPassword" value="${user.userPwd}"/>
                            <%--<a onclick="document.getElementById('_form').submit();">点击提交</a>--%>
                        <a href="#" class="glyphicon glyphicon-eye-open" title="查看数据" onclick="showUserData();"></a>
                    </form>
                </c:if>
            </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 680px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">USER</h4>
            </div>
            <div class="modal-body">
                <div style="padding: 10px 16px 10px;">
                    <form class="bs-example bs-example-form" role="form">
                        <div class="input-group">
                            <span class="input-group-addon">userId</span>
                            <input type="text" class="form-control" placeholder="userId" id="form-userId">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">userName</span>
                            <input type="text" class="form-control" placeholder="userName" id="form-userName">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">userPwd</span>
                            <input type="text" class="form-control" placeholder="userPwd" id="form-userPwd">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">userEmail</span>
                            <input type="text" class="form-control" placeholder="userEmail" id="form-userEmail">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">appEui</span>
                            <input type="text" class="form-control" placeholder="appEui" id="form-appEui">
                        </div>
                        <br/>
                        <div class="input-group">
                            <span class="input-group-addon">userRole</span>&nbsp;&nbsp;
                            <label class="radio-inline">
                                <input type="radio" name="form-userRole" id="optionsRadios3" value="user" checked> User
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="form-userRole" id="optionsRadios4" value="admin"> Admin
                            </label>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitUser(this)" id="saveOrEdit">Save</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    function submitUser(node) {
        var currModel = $(node).text()
        var userId = $("#form-userId").val()
        var userName = $("#form-userName").val()
        var userEmail = $("#form-userEmail").val()
        var userPwd = $("#form-userPwd").val()
        var appEui = $("#form-appEui").val()
        var userRole = $("input[name='form-userRole']:checked").val();
        if (currModel == "Save") {
            $.ajax({
                type: 'POST',
                url: "submitAddUser",
                async: false,
                data: {
                    userId: userId,
                    userName: userName,
                    userEmail: userEmail,
                    userRole: userRole,
                    userPwd: userPwd,
                    appEui: appEui
                },
                success: function (data) {
                    $('#myModal').modal('hide')
                    if (data == 0) {
                        alert("添加失败")
                    } else {
                        alert("添加成功")
                    }
                }
            });

        } else if (currModel == "Update") {
            $.ajax({
                type: 'POST',
                url: "submitUpdateUser",
                async: false,
                data: {
                    userId: userId,
                    userName: userName,
                    userEmail: userEmail,
                    userPwd: userPwd,
                    appEui: appEui
                },
                success: function (data) {
                    $('#myModal').modal('hide')
                    if (data == 0) {
                        alert("修改失败")
                    } else {
                        alert("修改成功")
                    }
                }
            });
        }
    }


    function showUserData() {
        var uid = $("#userId").val()
        var pwd = $("#userPassword").val()
        $.ajax({
            type: 'POST',
            url: "checkUser",
            async: false,
            data: {
                userId: uid,
                userPwd: pwd
            },
            success: function (data) {
                if (data == 0) {
                    alert("userId or pwd error！")
                } else {
                    document.getElementById('_form').submit();
                }
            }
        });
    }

    function delUser() {
        alert("delUser")
    }

    function addUser() {
        $("#myModal").modal({
            backdrop: 'static',
            keyboard: false
        });
        $("#form-userId").val("")
        $("#form-userName").val("")
        $("#form-userEmail").val("")
        $("#form-userPwd").val("")
        $("#form-appEui").val("")
        $("#saveOrEdit").text("Save")

    }

    function editUser(node) {
        var tr = $(node).parent().parent().children()
        var flag = $(tr.get(1)).text();

        if (flag == "on") {
            alert("任务正在运行,修改前请先关闭")
            return;
        }
        $("#myModal").modal({
            backdrop: 'static',
            keyboard: false
        });

        $("#form-userId").val($(tr.get(1)).text())
        $("#form-userName").val($(tr.get(2)).text())
        $("#form-userPwd").val($(tr.get(3)).text())
        $("#form-userEmail").val($(tr.get(4)).text())
        $("input[name='form-userRole'][value='" + $(tr.get(5)).text() + "']").prop("checked", "checked");
        $("#form-appEui").val($(tr.get(6)).text())

        $("#saveOrEdit").text("Update")
    }

    function startReceiveData(node) {
        var appStatus = $($(node).parent().parent().children().get(0));
        var uid = $($(node).parent().parent().children().get(1)).text();
        var appEui = $($(node).parent().parent().children().get(6)).text();
        $.ajax({
            type: 'POST',
            url: "startReceiveData",
            async: false,
            data: {
                userId: uid,
                appEui: appEui
            },
            success: function (data) {
                if (data == "1") {
                    if (appStatus.text().trim() == "Off") {
                        appStatus.children().text("On");
                        appStatus.children().attr("style", "color: rgb(0, 129, 0);");
                        appStatus.parent().attr("style", "background: #54ff00;")
                        alert("该appEui启动成功...")
                    }
                } else if (data == 2) {
                    alert("该appEui已启动...")
                } else if (data == 3) {
                    appStatus.parent().attr("style", "background: #ffb200;")
                    alert("该appEui注册失败")
                }
            }
        });
    }

    function stopReceiveData(node) {
        var appStatus = $($(node).parent().parent().children().get(0));
        var uid = $($(node).parent().parent().children().get(1)).text();
        var appEui = $($(node).parent().parent().children().get(6)).text();
        $.ajax({
            type: 'POST',
            url: "stopReceiveData",
            async: false,
            data: {
                userId: uid,
                appEui: appEui
            },
            success: function (data) {
                if (data == "1") {
                    if (appStatus.text().trim() == "On") {
                        appStatus.children().text("Off");
                        appStatus.children().attr("style", "color: rgb(255, 0, 0);");
                        appStatus.parent().attr("style", "background: #fff3b5;")
                        alert("该appEui停止成功...")
                    }
                } else if (data == 2) {
                    alert("该appEui已停止...")
                }
            }
        });
    }
</script>
</body>
</html>
