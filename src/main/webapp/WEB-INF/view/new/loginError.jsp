<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="new/css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
  <body>
      <div class="page-error tile">
        <h1><i class="fa fa-exclamation-circle"></i> UserName Login Error For : <label>${userId}</label></h1>
        <p>Please check your username and password, or contact to admin</p>
        <p><a class="btn btn-primary" href="javascript:window.history.back();">Go Back</a></p>
      </div>
  </body>
</html>