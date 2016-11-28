<%@ page import="domains.User" %><%
    User user = (User)session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("index.jsp");

    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
    <link rel="stylesheet" href="../css/custom.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<nav class="nav-extended">
    <div class="nav-wrapper">
        <a href="#" class="brand-logo center">DeeR*QuiZ</a>
        <ul id="nav-mobile" class="left hide-on-med-and-down">
            <li class="active"><a href="home?page=home">Home</a></li>
            <li><a href="ulist?page=list">User</a></li>
            <li><a href="qlist?page=list">Question</a></li>
            <li><a href="playquiz?page=play">Play Quiz</a> </li>
            <li><a href="logout?page=logout" >Logout</a></li>
        </ul>
    </div>
</nav>
</html>