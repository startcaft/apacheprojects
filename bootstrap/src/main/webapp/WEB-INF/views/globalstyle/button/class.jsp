<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap Template</title>

    <!-- Bootstrap main css file,required -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme css file,optional -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

    <h2>预定义样式</h2>
    <p>
        Bootstrap提供了一系列 button class ，用以快速创建一个带有预定义样式的按钮
    </p>
    <button class="btn btn-default" type="button">默认样式(btn-default)</button>
    <button class="btn btn-primary" type="button">主要选项(btn-primary)</button>
    <button class="btn btn-success" type="button">成功(btn-success)</button>
    <button class="btn btn-info" type="button">一般信息(btn-info)</button>
    <button class="btn btn-warning" type="button">警告(btn-warning)</button>
    <button class="btn btn-danger" type="button">危险(btn-danger)</button>
    <button class="btn btn-link" type="button">链接(btn-link)</button>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
