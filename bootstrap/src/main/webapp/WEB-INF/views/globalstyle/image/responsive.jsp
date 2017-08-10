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

    <h2>响应式图片</h2>
    <p>
        在 Bootstrap3 中，通过为图片添加 <code>.img-responsive</code> 类可以让图片支持响应式布局，从而让图片在其父元素中更好的缩放。
    </p>
    <p>
        如果想让使用了 <code>.img-responsive</code> 类的图片水平居中，请使用 <code>.center-block</code>，不要用 <code>.text-center</code>
    </p>
    <img src="${pageContext.request.contextPath}/statics/images/haima.jpg" class="img-responsive" alt="Responsive image">


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
