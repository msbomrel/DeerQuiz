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
        <h2>Edit User</h2>
    </div>
    <form action="update?id=${user.id}" method="post">
        <input type="hidden" name="page" value="update"/>
        <div class="input-field col s6">
            <input id="uname" name="username" type="text" value="${user.name}" class="validate">
            <label for="uname">Username</label>
        </div>
        <div class="input-field col s6">
            <input id="pass" name="password" type="text" value="${user.password}" class="validate">
            <label for="pass">Password</label>
        </div>
        <div class="input-field col s6">
            <input id="r" name="role" type="text" value="${user.role}" class="validate">
            <label for="r">Role</label>
        </div>
        <button class="btn waves-effect waves-teal" type="submit">Update</button>
    </form>
</div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/materialize.min.js"></script>
</body>
</html>