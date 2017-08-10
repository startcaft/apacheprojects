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

    <h2>两段对齐排列的按钮组</h2>
    <p>
        按钮组加上 <code>.btn-group-justified</code> 即可。
        让一组按钮组拉长为相同的尺寸，填满父元素的宽度，一般手机端使用的比较多。
    </p>
    <div>
        <div class="btn-group btn-group-justified">
            <a href="#" class="btn btn-default" role="button">Left</a>
            <a href="#" class="btn btn-default" role="button">Middle</a>
            <a href="#" class="btn btn-default" role="button">Right</a>
        </div>
        <br>
        <div class="btn-group btn-group-justified">
            <a href="#" class="btn btn-default" role="button">Left</a>
            <a href="#" class="btn btn-default" role="button">Middle</a>
            <div class="btn-group">
                <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Dropdown <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                </ul>
            </div>
        </div>
        <hr/>
        <div class="btn-group btn-group-justified">
            <div class="btn-group">
                <button type="button" class="btn btn-default">Left</button>
            </div>
            <div class="btn-group">
                <button type="button" class="btn btn-default">Middle</button>
            </div>
            <div class="btn-group">
                <button type="button" class="btn btn-default">Right</button>
            </div>
        </div>
    </div>


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
