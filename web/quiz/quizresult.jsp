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
    <div class="card" style="margin-left: 10px;">
        <h3>Quiz Results</h3>
        <b><h3>Your score is: ${totalCorrectAnswers} out of ${totalQuestions} </h3></b>
        <c:forEach items="${questionAndSelectedAnswers}" var="questionAndAnswer">
            Question :${questionAndAnswer.question.question}<br>
            *********************************************************************************<br>
            <br>
            Option 1 :
            ${questionAndAnswer.question.option1}
            <br>
            Option 2 :
            ${questionAndAnswer.question.option2}
            <br>
            Option 3 :
            ${questionAndAnswer.question.option3}
            <br>
            Option 4 :
            ${questionAndAnswer.question.option4}
            <br>
            Correct Answer :
            ${questionAndAnswer.question.correctanswer}
            <br>
            Selected Answer :
            ${questionAndAnswer.answer}
            <br>
            <br>
            <c:if test="${questionAndAnswer.question.correctanswer==questionAndAnswer.answer}">
                <p style="color:darkgreen;font-size: large">CORRECT</p>
            </c:if>
            <c:if test="${questionAndAnswer.question.correctanswer!=questionAndAnswer.answer}">
                <p style="color:red;font-size: large">WRONG</p>
            </c:if>
            <br>
        </c:forEach>

    </div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/materialize.min.js"></script>
</body>
</html>