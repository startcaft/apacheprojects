<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 页面主体</title>

    <!-- Bootstrap main css file,required -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme css file,optional -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

    <p>
        bootstrap将全局 <code>font-size</code> 设置为 <strong>14px</strong>，
        <code>line-height</code> 设置为 <strong>1.428</strong>。
        这些属性直接赋予 <code>&lt;body&gt;</code> 元素和所有段落元素。
        另外，<code>&lt;p&gt;</code> 元素还被设置了等于 1/2 行高（即10px）的底部外边距（margin）。
    </p>
    <p>
        通过添加 <code>.lead</code> 类可以让段落突出显示
    </p>
    <p class="lead">被突出显示的段落</p>
    <p>正常段落</p>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
