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
        <div class="content"></div>
        <form action="playquiz" method="post">
            <input type="hidden" name="page" value="submitAnswer"/>
            <input type="hidden" name="id" value="${question.id}"/>
            <center><h3>${question.question}</h3></center>
            <div class="row">
            <div class="col s6">
                <p>
                    <input class="with-gap" name="answer" value="${question.option1}" type="radio" id="option1"/>
                    <label for="option1">${question.option1}</label>
                </p>
            </div>
            <div class="col s6">
                <p>
                    <input class="with-gap" name="answer" value="${question.option2}" type="radio" id="option2"/>
                    <label for="option2">${question.option2}</label>
                </p>
            </div>
            <div class="col s6">
                <p>
                    <input class="with-gap" name="answer" value="${question.option3}" type="radio" id="option3"/>
                    <label for="option3">${question.option3}</label>
                </p>
            </div>
            <div class="col s6">
                <p>
                    <input class="with-gap" name="answer" value="${question.option4}" type="radio" id="option4"/>
                    <label for="option4">${question.option4}</label>
                </p>
            </div>
            </div>
            <button class="btn" value="Next" type="submit">Next</button>
        </form>
    </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/materialize.min.js"></script>
</body>
</html>