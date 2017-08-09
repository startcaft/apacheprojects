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
</head>
<body>

    <h2>Help Text</h2>
    <p>
        怎么解释呢？感觉像是表单控件的辅助文本。<code>help-block</code> 修饰的段落，只一个块级元素。
    </p>
    <div class="form-group">
        <label class="sr-only" for="inputHelpBlock">Input with help text</label>
        <input type="text" id="inputHelpBlock" class="form-control" aria-describedby="helpBlock">
        <span id="helpBlock" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
    </div>


    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
