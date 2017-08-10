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

    <h2>情境文本颜色</h2>
    <p>
        通过颜色来展示意图，Bootstrap 提供了一组工具类。这些类可以应用于 链接，并且在鼠标经过时颜色还可以加深。
    </p>
    <p class="text-muted">.text-muted 情境文本颜色</p>
    <p class="text-primary">.text-primary 情境文本颜色</p>
    <p class="text-success">.text-success 情境文本颜色</p>
    <p class="text-info">.text-info 情境文本颜色</p>
    <p class="text-warning">.text-warning 情境文本颜色.</p>
    <p class="text-danger">.text-danger 情境文本颜色</p>
    <hr/>
    <a class="text-info" href="http://www.baidu.com">链接到百度</a>


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
