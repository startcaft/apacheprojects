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

    <h2>按钮</h2>
    <p>
        为 <code>&lt;a&gt;</code>，<code>&lt;button&gt;</code> 或 <code>&lt;input&gt;</code> 元素添加按钮类（button class）即可使用 Bootstrap 提供的样式
    </p>
    <a class="btn btn-default" href="#" role="button">Link</a>
    <button class="btn btn-default" type="submit">Button</button>
    <input type="button" class="btn btn-default" value="Input"/>
    <input type="submit" class="btn btn-default" value="Submit"/>
    <hr/>

    <p>
        虽然 button class 可以应用到 <code>&lt;a&gt;</code> 和 <code>&lt;button&gt;</code> 元素上，但是，导航和导航组件只支持 <code>&lt;button&gt;</code> 元素
    </p>
    <p>
        如果 <code>&lt;a&gt;</code> 元素被用作按钮使用，并用于在当前页面出发某些功能，而不是用于链接到其他页面或当前页面中的其他部分，
        那么，务必为其设置 <code>role="button"</code> 属性。
    </p>
    <p>
        官方强烈建议尽可能使用 <code>&lt;button&gt;</code> 元素。
    </p>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
