<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 网格系统</title>
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

    <p>包裹在容器中的网格系统，一般都是包裹在bootstrap容器中，列的个数不要超过12</p>
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

    <hr/>

    <p>没有包裹在bootstrap容器中</p>
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


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
