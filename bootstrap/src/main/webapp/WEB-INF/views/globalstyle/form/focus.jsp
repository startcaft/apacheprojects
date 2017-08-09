<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 全局样式之表单</title>

    <!-- Bootstrap main css file,required -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme css file,optional -->
    <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <style type="text/css">
        #focusedInput {
            border-color: #ccc;
            border-color: rgba(82,168,236,.8);
            outline: 0;
            outline: thin dotted \9;
            -webkit-box-shadow: 0 0 8px rgba(82,168,236,.6);
            box-shadow: 0 0 8px rgba(82,168,236,.6);
        }
    </style>
</head>
<body>

    <h2>焦点状态</h2>
    <p>
        将表单控件的默认 <code>outline</code> 样式移除，然后对 <code>:focus</code> 状态赋予 <code>box-shadow</code> 属性
    </p>
    <input class="form-control" id="focusedInput" type="text" value="Demonstrative focus state">
    <hr/>
    <input class="form-control" id="focusedInput2" type="text" value="Demonstrative focus state2">

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
