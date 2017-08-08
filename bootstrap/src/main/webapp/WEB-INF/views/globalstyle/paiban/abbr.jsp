<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 缩略语</title>

    <!-- Bootstrap main css file,required -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme css file,optional -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

    <p>
        当鼠标悬停在缩写和缩写词上就会显示完整的内容。
        bootstrap 实现了对HTML的 <code>&lt;abbr&gt;</code> 元素的增加。
        缩略元素必须包含 title 属性。
    </p>
    <p>
        当缩略语添加 <code>.initialism</code> 类，可以让 font-size 变的稍微小一些。
    </p>
    <hr/>

    我是<abbr title="中国人">人</abbr><br/>
    <abbr title="HyperText Markup Language" class="initialism">HTML</abbr> is the best thing since sliced bread.

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
