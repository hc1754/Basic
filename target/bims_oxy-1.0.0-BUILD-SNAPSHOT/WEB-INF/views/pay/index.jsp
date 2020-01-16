<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Material Design Bootstrap</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="/resources/pay/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="/resources/pay/css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="/resources/pay/css/style.css" rel="stylesheet">
</head>

<body>
<table class="table">
    <thead>
    <tr>
        <th>id</th><th>email</th><th>firstname</th><th>lastname</th><th>password</th><th>gndr</th><th>brth</th><th>useyn</th><th>phone</th>
    </tr>
    </thead>

    <tbody>

    <c:if test="${not empty userList}">
        <c:forEach var="userList" items="${userList}">
            <tr>
            <td>${userList.QR_USR_ID}</td>
            <td>${userList.QR_USR_EMAIL}</td>
            <td>${userList.FMLY_NM}</td>
            <td>${userList.NM}</td>
            <td>${userList.QR_USR_PW}</td>
            <td>${userList.GNDR}</td>
            <td>${userList.BRTH_DAY}</td>
            <td>${userList.USE_YN}</td>
            <td>${userList.TMP_PHONE}</td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
