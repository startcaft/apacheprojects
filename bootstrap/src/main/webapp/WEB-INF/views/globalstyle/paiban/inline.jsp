<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 内联文本</title>

    <!-- Bootstrap main css file,required -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme css file,optional -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

    <p>
        <code>&lt;del&gt;</code> 标签包裹的是被删除的文本：<del>这是被删除的文本 </del>
    </p>
    <p>
        <code>&lt;s&gt;</code> 标签包裹的是被无用的文本：<s>这是无用的文本 </s>，个人感觉跟 <code>&lt;del&gt;</code> 标签的效果一样。
    </p>
    <p>
        <code>&lt;ins&gt;</code> 标签包裹的是额外插入的文本：<ins>这是额外插入的文本</ins>
    </p>
    <p>
        <code>&lt;u&gt;</code> 标签包裹的是带下划线的文本：<u>带下划线的文本</u>，个人感觉跟 <code>&lt;ins&gt;</code> 标签的效果一样。
    </p>
    <p>
        使用 <code>&lt;small&gt;</code> 标签或者 <code>.small</code>类可以设置小号文本，文本被设置为父容器字体大小的85%：
        <small>这是小号文本</small>
    </p>
    <p>
        <code>&lt;strong&gt;</code> 标签用于修饰强调（着重）一段文本：<strong>这是被强调的文本</strong>
    </p>
    <p>
        <code>&lt;em&gt;</code> 标签用斜体强调一段文本：<em>这是斜体强调的文本</em>
    </p>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
