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
        <h2>Question List</h2>
        <a style="margin-left: 10px;" class="btn-floating btn-large waves-effect waves-light green" href="questionAdd?page=addQuestion"><i class="material-icons">add</i></a>
        <table class="bordered">
            <tr>
                <th>Question</th>
                <th>Option 1</th>
                <th>Option 2</th>
                <th>Option 3</th>
                <th>Option 4</th>
                <th>Correct Answer</th>
                <th>Category</th>
                <th colspan="2">Action</th>
            </tr>
            <c:forEach items="${questionList}" var="question">
                <tr>
                    <td>${question.question}</td>
                    <td>${question.option1}</td>
                    <td>${question.option2}</td>
                    <td>${question.option3}</td>
                    <td>${question.option4}</td>
                    <td>${question.correctanswer}</td>
                    <td>${question.category}</td>
                    <td><a class="btn" href="questionedit?page=edit&id=${question.id}"><i class="material-icons">mode_edit</i> </a></td>
                    <td><a class="btn" href="questiondelete?page=delete&id=${question.id}"><i class="material-icons">delete</i> </a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/materialize.min.js"></script>
</body>
</html>