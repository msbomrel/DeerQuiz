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
    <%--<link rel="stylesheet" href="../css/materialize.min.css">--%>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
    <link rel="stylesheet" href="../css/custom.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container">
    <%@include file="../include/header.jsp"%>
    <div class="card">
        <div class="section"></div>
        <form action="storeQuestion" method="post">
            <input type="hidden" name="page" value="store"/>
            <div class="input-field col s6">
                <input id="question" name="question" type="text" class="validate">
                <label for="question">Question</label>
            </div>
            <div class="input-field col s6">
                <input id="option1" name="option1" type="text"  class="validate">
                <label for="option1">Option1</label>
            </div>
            <div class="input-field col s6">
                <input id="option2" name="option2" type="text"  class="validate">
                <label for="option2">Option2</label>
            </div>
            <div class="input-field col s6">
                <input id="option3" name="option3" type="text"  class="validate">
                <label for="option3">Option3</label>
            </div>
            <div class="input-field col s6">
                <input id="option4" name="option4" type="text"  class="validate">
                <label for="option4">Option4</label>
            </div>
            <div class="input-field col s6">
                <input id="correctanswer" name="correctanswer" type="text"  class="validate">
                <label for="correctanswer">CorrectAnswer</label>
            </div>
            <div class="input-field col s6">
                <input id="category" name="category" type="text"  class="validate">
                <label for="category">Category</label>
            </div>
            <input type="submit" value="Add" class="btn btn-default">

        </form>

    </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/materialize.min.js"></script>
</body>
</html>