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

    <h2>激活状态</h2>
    <p>
        当按钮处于激活状态，其表现为被按压下去（底色更深，边框夜色更深，向内投射阴影）；
        可以将 <code>.active</code> 类应用到 <code>&lt;button&gt;</code> 和 <code>&lt;a&gt;</code> 元素上，使其处于激活状态
    </p>

    <h3>button元素</h3>
    <button type="button" class="btn btn-primary btn-lg active">Primary button</button>
    <button type="button" class="btn btn-default btn-lg active">Button</button>
    <hr/>

    <h3>链接（<code>&lt;a&gt;</code>）元素</h3>
    <a href="#" class="btn btn-primary btn-lg active" role="button">Primary link</a>
    <a href="#" class="btn btn-default btn-lg active" role="button">Link</a>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
