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

    <h2>图片形状</h2>
    <p>
        通过为 <code>&lt;img&gt;</code> 添加 <code>.img-rounded</code>，<code>.img-circle</code> 和 <code>img-thumbnail</code>
        ，可以让图片呈现不同的形状。
    </p>
    <p>
        IE8 不支持 CSS3中的圆角属性。
    </p>
    <img src="${pageContext.request.contextPath}/statics/images/qq.jpg" alt="qq头像" class="img-rounded">
    <img src="${pageContext.request.contextPath}/statics/images/qq.jpg" alt="qq头像" class="img-circle">
    <img src="${pageContext.request.contextPath}/statics/images/qq.jpg" alt="qq头像" class="img-thumbnail">
    <hr/>
    <img src="${pageContext.request.contextPath}/statics/images/qq.jpg" alt="qq头像" class="img-rounded" width="90" height="90">
    <img src="${pageContext.request.contextPath}/statics/images/qq.jpg" alt="qq头像" class="img-circle" width="90" height="90">
    <img src="${pageContext.request.contextPath}/statics/images/qq.jpg" alt="qq头像" class="img-thumbnail" width="90" height="90">


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
