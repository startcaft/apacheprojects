<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 引用</title>

    <!-- Bootstrap main css file,required -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme css file,optional -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

    <p class="lead">
        在我们的文档中引用其他来源的内容。
        将任何 HTML 元素包裹在 <code>&lt;blockquote&gt;</code> 中即可表现为引用样式。对于直接应用，官方建议使用 <code>&lt;p&gt;</code> 标签。
    </p>
    <blockquote>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
    </blockquote>
    <hr/>

    <p>
        对于标准同样是的 <code>&lt;blockquote&gt;</code> 添加<code>&lt;footer&gt;</code> 用于标明引用来源。
        来源的名称可以包裹进 <code>&lt;cite&gt;</code> 标签中。
    </p>
    <blockquote>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
        <footer>
            Someone famous in <cite title="Source Title">Source Title</cite>
        </footer>
    </blockquote>
    <hr/>

    <p>
        通过对 <code>&lt;blockquote&gt;</code> 标签添加 <code>.blockquote-reverse</code> 类可以让引用内容呈现右对齐的效果。
    </p>
    <blockquote class="blockquote-reverse">
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
        <footer>
            Someone famous in <cite title="Source Title">Source Title</cite>
        </footer>
    </blockquote>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
