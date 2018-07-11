<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>提示</title>

    <!--使用ueditor需要导入的js-->
    <script type="text/javascript" src="../../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="../../ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" src="../../ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        #div_1 {
            border: thin none #069;
            padding: 1px;
            float: none;
            width: 500px;
            height: 300px;
            background-color: #9C6;
        }
    </style>
</head>
<body>
<!-- 加载编辑器的容器 -->
<%--<script id="container" name="content" type="text/plain"> </script>--%>
<script type="text/javascript">
    //<!-- 实例化编辑器 -->
    var ue = UE.getEditor('container');


</script>

</body>
</html>