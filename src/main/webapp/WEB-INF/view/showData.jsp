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
    <div class="row">
        <h2>DataReceived:</h2>
    </div>
    <div class="row">
        <div class="col-lg-1"><label>appEui:</label></div>
        <div class="col-lg-2" id="sumAppEui">${user.appEui}</div>
        <div class="col-lg-1"><label>devEui:</label></div>
        <div class="col-lg-4"></div>
        <div class="col-lg-3"></div>
        <div class="col-lg-1"><a class="glyphicon glyphicon-pause"><label>暂停</label></a></div>
    </div>
    <br/>
    <div class="table-responsive">
        <table id="table" cellpadding="4" cellspacing="0" class="table table-bordered table-striped text-nowrap">
            <thead>
            <tr>
                <th data-field="all">all</th>
                <th data-field="createTime">createTime</th>
                <th data-field="appEui">appEui</th>
                <th data-field="devEui">devEui</th>
                <th data-field="realData">realData</th>
            </tr>
            </thead>
            <tbody id="tData">
            <c:forEach var="dl" items="${datasList}">
                <tr>
                    <td><a onclick="showAll(this)" class="glyphicon glyphicon-plus" href="#"></a></td>
                    <td>${dl.createTime}</td>
                    <td>${dl.appEui}</td>
                    <td>${dl.devEui}</td>
                    <td>${dl.realData}</td>
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
            $(fullDatas.get(i)).parent().parent().hide()
        }

        var tas = $(".json-toggle");
        for (var i = 0; i < tas.length; i++) {
            $(tas.get(i)).attr("href", "javascript:void(0)")
        }
        setInterval("refreshData()", 5000)
    });

    function refreshData() {
        var appEui = $("#sumAppEui").text()
        var preTime = $($("#tData").find("td").get(1)).text()
        console.log(appEui)
        console.log(preTime)
        $.ajax({
            type: 'POST',
            url: "refreshData",
            async: false,
            data: {
                appEui: appEui,
                createTime: preTime
            },
            success: function (datas) {
                if (datas != 0) {
                    for (var i = 0; datas.length; i++) {
                        data = datas[i]
                        var trr = $("<tr>")
                        var tdr = $("<td colspan='5'>")
                        var prer = $("<pre name='fullData' style='display: none;'>")
                        prer.text(data.jsonData)
                        tdr.append(prer)
                        trr.append(tdr)
                        $("#tData").prepend(trr)

                        var input = eval('(' + data.jsonData + ')');
                        prer.text("")
                        var options = {
                            collapsed: false,
                            withQuotes: false
                        };
                        $(prer).jsonViewer(input, options);

                        var trd = $("<tr>")
                        var tdd1 = $("<td>")
                        var tdda = $("<a onclick='showAll(this)' class='glyphicon glyphicon-plus' href='#'>")
                        tdd1.append(tdda)
                        var tdd2 = $("<td>")
                        tdd2.text(data.createTime)
                        var tdd3 = $("<td>")
                        tdd3.text(data.appEui)
                        var tdd4 = $("<td>")
                        tdd4.text(data.devEui)
                        var tdd5 = $("<td>")
                        tdd5.text(data.realData)

                        trd.append(tdd1)
                        trd.append(tdd2)
                        trd.append(tdd3)
                        trd.append(tdd4)
                        trd.append(tdd5)
                        $("#tData").prepend(trd)
                        $("#tData").children("tr:last-child").remove()

                        $("#tData").children("tr:last-child").remove()
                        trd.slideUp(300).delay(200).fadeIn(400);
                    }
                }
            }
        });
    }


    function showAll(node) {
        var textNode = $(node).parent().parent().next().children().children();
        if (textNode.is(":hidden")) {
            textNode.show()
            $(node).attr("class", "glyphicon glyphicon-minus")
        } else {
            textNode.hide()
            $(node).attr("class", "glyphicon glyphicon-plus")
        }
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
