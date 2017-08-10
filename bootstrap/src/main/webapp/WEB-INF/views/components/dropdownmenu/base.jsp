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

    <h2>下拉菜单</h2>
    <p>
        用于显示链接列表的可切换，有上下文的菜单。
        将下拉菜单触发器和下拉菜单都包裹在 <code>.dropdown</code> 或另一个声明了 <code>position: relative;</code> 的元素。
        然后加入组成菜单的 HTML 代码，菜单使用 <code>dropdown-menu</code> 包裹。
    </p>
    <div class="dropdown">
        <button type="button" class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
            下拉菜单
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li><a href="#">Separated link</a></li>
        </ul>
    </div>
    <hr/>

    <p>
        通过为下拉菜单的父元素设置 <code>.dropup</code> 类，可以让菜单向上弹出（默认是向下弹出的）。
    </p>
    <div class="dropup">
        <button type="button" class="btn btn-default dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown">
            下拉菜单
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li><a href="#">Separated link</a></li>
        </ul>
    </div>


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
