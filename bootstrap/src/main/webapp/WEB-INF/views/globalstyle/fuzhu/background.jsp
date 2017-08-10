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

    <h2>情境背景色</h2>
    <p>
        和情境文本颜色一样，使用任何情境背景色类就可以设置元素的背景。
        链接组件在鼠标经过时颜色会加深，就和情境文本颜色类一样。
    </p>
    <p class="bg-primary">.bg-primary 情境背景色</p>
    <p class="bg-success">.bg-success 情境背景色</p>
    <p class="bg-info">.bg-info 情境背景色</p>
    <p class="bg-warning">.bg-warning 情境背景色</p>
    <p class="bg-danger">.bg-danger 情境背景色</p>
    <hr/>
    <a class="bg-info" href="http://www.baidu.com">链接到百度</a>


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
