<%--
  Created by IntelliJ IDEA.
  User: msbomrel
  Date: 11/14/16
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
    <link rel="stylesheet" href="../css/custom.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container">
<%@include file="../include/header.jsp"%>
<div class="card">
        <div class="content_section">
            <h2>Add new User</h2>
        </div>
        <form action="storeUser" method="post">
            <input type="hidden" name="page" value="storeUser"/>
            <div class="input-field col s6">
                <input id="username" name="username" type="text" class="validate">
                <label for="username">UserName</label>
            </div>
            <div class="input-field col s6">
                <input id="password" name="password" type="text" class="validate">
                <label for="role">Password</label>
            </div>
            <div class="input-field col s6">
                <input id="role" name="role" type="text" class="validate">
                <label for="role">Role</label>
            </div>
            <input type="submit" value="Add User" class="btn btn-default">

        </form>
</div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/materialize.min.js"></script>
</body>
</html>