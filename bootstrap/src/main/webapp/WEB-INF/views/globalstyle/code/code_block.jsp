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

    <h2>代码块</h2>
    <p>
        代码块可以使用 <code>&lt;pre&gt;</code> 标签包裹。为了正确的展示代码，注意将尖括号做转义处理
    </p>
    <p>
        <pre>&lt;p&gt;Sample code here...&lt;/p&gt;</pre>
    </p>
    <hr/>

    <p>
        还可以使用 <code>,pre-scrollable</code> 类，其作用是设置 max-height 为 350px，并在垂直方向展示滚动条
    </p>
    <pre>
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
        &lt;p&gt;Sample code here...&lt;/p&gt;
    </pre>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
