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

    <h2>禁用的菜单项</h2>
    <p>
        为下拉菜单中的 <code>&lt;li&gt;</code> 元素添加 <code>.disable</code> 类，从而禁用相应的菜单项
    </p>
    <div class="dropdown">
        <button type="button" class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
            下拉菜单
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="#">Action1</a></li>
            <li><a href="#">Another action1</a></li>
            <li><a href="#">Something else here1</a></li>
            <li class="disabled"><a href="#">Separated link1</a></li>
        </ul>
    </div>


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
