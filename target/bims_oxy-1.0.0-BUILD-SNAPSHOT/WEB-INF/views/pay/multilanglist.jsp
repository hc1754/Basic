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
        <th>langcd</th><th>item distc</th><th>item id</th><th>item name</th><th>regid</th><th>regdt</th>
    </tr>
    </thead>

    <tbody>

    <c:if test="${not empty multiLangList}">
        <c:forEach var="multiLangList" items="${multiLangList}">
            <tr>
                <td>${multiLangList.LANG_CD}</td>
                <td>${multiLangList.SCRN_ITEM_DISTC}</td>
                <td>${multiLangList.SCRN_ITEM_ID}</td>
                <td>${multiLangList.DISP_CONT}</td>
                <td>${multiLangList.REG_ID}</td>
                <td>${multiLangList.REG_DT}</td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
