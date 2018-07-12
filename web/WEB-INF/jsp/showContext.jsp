<%@ page pageEncoding="UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>显示文章内容</title>
</head>
<nav>
    <ul class="breadcrumb">
        <li><a href="/admin_category_list"><span>${c.name}</span></a></li>
        <li><a href="/admin_article_list?cid=${c.id}"><span>${a.title}</span></a></li>
        <c:if test="${r !=null}">
            <li><a href="/admin_review_list?aid=${a.id}">评论内容</a></li>
        </c:if>
        <c:if test="${r ==null}">
            <li class="active"><span>文章内容</span></li>
        </c:if>
    </ul>
</nav>
<body>


<div style="margin:40px  auto;margin-left: 160px;margin-right: 160px">
    <c:if test="${r==null}">${a.context_}</c:if>
    <c:if test="${r!=null}">${r.context_}</c:if>
</div>
</body>
</html>
