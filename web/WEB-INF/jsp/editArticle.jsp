<%@ page pageEncoding="UTF-8"  language="java" %>
<%@include file="../include/admin/head.jsp"%>
<%@include file="../include/admin/nav.jsp"%>
<script>
    $(function () {
        $("#editForm").submit(function () {
            var html = ue.getContent();
            // var txt = ue.getContentTxt();
            $("#context_").attr("value",html);
            // alert(html);
            // alert(txt);
            return true;
        });
    });
</script>
<html>
<head>
    <title>编辑文章内容</title>
</head>
<nav>
    <ul class="breadcrumb">
        <li><a href="/admin_category_list"><span>${c.name}</span></a></li>
        <li><a href="/admin_article_list?cid=${c.id}"><span>${a.title}</span></a></li>
        <li class="active"><span>文章内容</span></li>
    </ul>
</nav>
<body>
<div class="panel-warning" style="margin:40px auto;width: 900px">
    <div class="panel-heading" align="center">文章编辑</div>
    <div class="panel-body" align="center">
        <form id="editForm" action="admin_article_update" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>标题</td>
                    <td><input  type="text" class="form-control" id="title" value="${a.title}" name="title"></td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input type="text" class="form-control" id="keyword" value="${a.keyword}" name="keyword"></td>
                    <td><input type="hidden" id="cid" name="category_id" value="${c.id}"></td>
                    <td><input type="hidden" id="id" name="id" value="${a.id}"></td>
                </tr>
                <tr>
                    <td>内容</td>
                    <td>
                        <script id="container" name="container" type="text/plain">${a.context_}</script>
                        <input type="hidden" id="context_" name="context_" value="">
                        <%@include file="../include/admin/ueditor.jsp"%>
                    </td>
                    <td><input type="hidden" id="viewcount" name="viewcount" value="${a.viewcount}"></td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <input type="submit" value="提交" class="btn-success"  >
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
