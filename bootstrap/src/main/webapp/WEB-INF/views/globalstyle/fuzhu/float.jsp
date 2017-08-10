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

    <h2>快速浮动</h2>
    <p>
        通过添加 <code>.pull-left</code>，<code>.pull-right</code>，可以将任意元素向左或向右浮动。
    </p>
    <div>
        <div class="pull-left">AAAAA</div>
        <div class="pull-right">BBBBB</div>
    </div>
    <div>
        不能用于导航条组件中，排列导航条中的组件时可以使用 <code>.navbar-left</code> 或 <code>.navbar-right</code> 。
    </div>
    <hr/>

    <h2>清除浮动</h2>
    <p>
        通过为父元素 添加 <code>.clearfix</code> 类可以很容易地清除浮动。
    </p>
    <div class="clearfix">
        <div class="pull-left">AAAAA</div>
        <div class="pull-right">BBBBB</div>
    </div>


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
