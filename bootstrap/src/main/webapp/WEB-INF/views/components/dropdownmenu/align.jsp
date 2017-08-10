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

    <h2>对齐</h2>
    <p>
        默认情况下，下拉菜单自动沿着父元素的上沿和左侧被定为 100% 宽度。
        为 <code>.dropdown-menu</code> 添加 <code>.dropdown-menu-right</code> 或 <code>.dropdown-menu-left</code>
        类 可以让菜单向左或向右对齐
    </p>
    <p>
        自 Bootstrap3 之后，官方不再建议使用 <code>.pull-right</code> 或 <code>.pull-left</code> 来对齐了
    </p>
    <div class="dropdown" style="width: 300px">
        <button type="button" class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
            下拉菜单对齐
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li><a href="#">Separated link</a></li>
        </ul>
    </div>
    <hr/>


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
