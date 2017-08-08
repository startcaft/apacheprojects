<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 容器</title>
    <style>
        .c {
            border: 1px solid gray;
        }
    </style>

    <!-- Bootstrap main css file,required -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme css file,optional -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

    <p>.container容器，用于固定宽度并支持响应式布局的容器</p>
    <div class="container">
        <div class="row">
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
        </div>
    </div>

    <p>.container-fluid容器，用于100%宽度，占据全部视口（viewport）的容器</p>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
            <div class="col-lg-1 c">.col-lg-1</div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
