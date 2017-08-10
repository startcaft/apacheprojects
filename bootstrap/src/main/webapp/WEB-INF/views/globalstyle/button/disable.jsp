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


    <h2>button元素</h2>
    <p>
        为 <code>&lt;button&gt;</code> 元素添加 <code>disable</code> 属性，使其表现出禁用状态。
        IE9 下有兼容性问题。
    </p>
    <button type="button" class="btn btn-lg btn-primary" disabled="disabled">Primary button</button>
    <button type="button" class="btn btn-default btn-lg" disabled="disabled">Button</button>
    <hr/>

    <h2>链接（<code>&lt;a&gt;</code>）元素</h2>
    <p>
        为基于 <code>&lt;a&gt;</code> 元素创建的按钮添加 <code>.disable</code>类，使其变现出禁用状态。
    </p>
    <a href="#" class="btn btn-primary btn-lg disabled" role="button">Primary link</a>
    <a href="#" class="btn btn-default btn-lg disabled" role="button">Link</a>
    <hr/>

    <p>
        Bootstrap 官方把 <code>.disable</code> 作为工具类使用，就像 <code>.active</code> 类一样，因此不需要增加前缀。
    </p>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
