<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 标题</title>

    <!-- Bootstrap main css file,required -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme css file,optional -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

    <p>
        标题标签从<code>&lt;h1&gt;</code>到<code>&lt;h6&gt;</code>都可用;
        另外，bootstrap还提供了<code>.h1</code>到<code>.h6</code>类，为的是给内联(inline)属性的文本赋予标题的样式。
    </p>
    <h1>h1. Bootstrap heading</h1>
    <h2>h2. Bootstrap heading</h2>
    <h3>h3. Bootstrap heading</h3>
    <h4>h4. Bootstrap heading</h4>
    <h5>h5. Bootstrap heading</h5>
    <h6>h6. Bootstrap heading</h6>
    <hr/>

    <p>
        在标题内还可以包含<code>&lt;small&gt;</code>标签或赋予<code>.small</code>类的元素，可以用来标记副标题。
    </p>
    <h1>h1. Bootstrap heading <small>Secondary text</small></h1>
    <h2>h2. Bootstrap heading <small>Secondary text</small></h2>
    <h3>h3. Bootstrap heading <small>Secondary text</small></h3>
    <h4>h4. Bootstrap heading <small>Secondary text</small></h4>
    <h5>h5. Bootstrap heading <small>Secondary text</small></h5>
    <h6>h6. Bootstrap heading <small>Secondary text</small></h6>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
