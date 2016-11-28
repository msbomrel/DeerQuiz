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
        <h2 style="margin-left: 10px;">User List</h2>
        <a style="margin-left: 10px;" class="btn-floating btn-large waves-effect waves-light green" href="userForm?page=addUser"><i class="material-icons">add</i></a>
        <table class="bordered centered">
            <thead>
            <tr>
                <th>Username</th>
                <th>Password</th>
                <th>Role</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <c:forEach items="${userList}" var="user">
                <tbody>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.password}</td>
                    <td>${user.role}</td>
                    <td><a class="btn-flat" href="useredit?page=edit&id=${user.id}"><i class="material-icons">mode_edit</i></a></td>
                    <td><a class="btn-flat" href="userdelete?page=delete&id=${user.id}"><i class="material-icons">delete</i></a></td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/materialize.min.js"></script>
</body>
</html>