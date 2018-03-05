<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--[if lt IE 7]>
<html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>
<html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>
<html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Login Lora</title>
    <link rel="stylesheet" href="css/style.css">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
<section class="container">
    <div class="login">
        <h1>Login to Web App</h1>
        <form method="post" id="mainForm">
            <p><input type="text" name="userId" value="" placeholder="UserId" id="userId"></p>
            <p><input type="password" name="userPassword" value="" placeholder="Password" id="userPassword"></p>
            <p class="remember_me">
                <label>
                    <input type="checkbox" name="remember_me" id="remember_me">
                    Remember me on this computer
                </label>
            </p>
            <p class="submit"><input type="submit" name="commit" value="Login" onclick="checkUser();"></p>
        </form>
    </div>

    <div class="login-help">
        <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
    </div>
</section>

<!--<section class="about">-->
<!--<p class="about-links">-->
<!--<a href="http://www.cssflow.com/snippets/login-form" target="_parent">View Article</a>-->
<!--<a href="http://www.cssflow.com/snippets/login-form.zip" target="_parent">Download</a>-->
<!--</p>-->
<!--<p class="about-author">-->
<!--&copy; 2012&ndash;2013 <a href="http://thibaut.me" target="_blank">Thibaut Courouble</a> - -->
<!--<a href="http://www.cssflow.com/mit-license" target="_blank">MIT License</a><br>-->
<!--Original PSD by <a href="http://www.premiumpixels.com/freebies/clean-simple-login-form-psd/" target="_blank">Orman Clark</a>-->
<!--</section>-->
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript">
    function checkUser() {
        var uid = $("#userId").val()
        var pwd = $("#userPassword").val()
        if (uid == "" || pwd == "") {
            alert("uid or pwd can not be empty input!")
        } else {
            $.ajax({
                type: 'POST',
                url: "checkUser",
                async: false,
                data: {
                    userId: uid,
                    userPwd: pwd,
                    select: 'show'
                },
                success: function (data) {
                    if (data == 0) {
                        alert("userId or pwd error！")
                    } else {
                        if (data.userRole != "user") {
                            $("#mainForm").attr("action", "adminUser")
//                            window.location.href = "adminUser?userId=" + data.userId + "&userPwd=" + data.userPwd;
//                            return;
                        } else {
                            $("#mainForm").attr("action", "commonUser")
//                            window.location.href = "commonUser?userId=" + data.userId + "&userPwd=" + data.userPwd;
//                            return;
                        }
                    }
                }
            });
        }

    }
</script>
</body>
</html>
