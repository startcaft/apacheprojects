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

    <h2>尺寸</h2>
    <p>
        需要让按钮具有不同尺寸，那么使用 <code>.btn-lg</code>，<code>.btn-sm</code>，<code>.btn-xs</code>
        就可以获得不同尺寸的按钮
    </p>
    <p>
        <button type="button" class="btn btn-primary btn-lg">（大按钮）Large button</button>
        <button type="button" class="btn btn-default btn-lg">（大按钮）Large button</button>
    </p>
    <p>
        <button type="button" class="btn btn-primary">（默认尺寸）Default button</button>
        <button type="button" class="btn btn-default">（默认尺寸）Default button</button>
    </p>
    <p>
        <button type="button" class="btn btn-primary btn-sm">（小按钮）Small button</button>
        <button type="button" class="btn btn-default btn-sm">（小按钮）Small button</button>
    </p>
    <p>
        <button type="button" class="btn btn-primary btn-xs">（超小尺寸）Extra small button</button>
        <button type="button" class="btn btn-default btn-xs">（超小尺寸）Extra small button</button>
    </p>
    <hr/>

    <p>
        通过给按钮添加 <code>.btn-block</code> 类可以将其拉伸至父元素100%的宽度，而且按钮也变成了块级（block）元素
    </p>
    <button type="button" class="btn btn-primary btn-lg btn-block">（块级元素）Block level button</button>
    <button type="button" class="btn btn-default btn-lg btn-block">（块级元素）Block level button</button>


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
