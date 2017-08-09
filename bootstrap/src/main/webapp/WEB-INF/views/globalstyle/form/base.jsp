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

    <h2>基本表单实例</h2>
    <p>
        单独的表单控件会被自动赋予一些全局样式。所有设置了 <code>.form-control</code> 类的 <code>&lt;input&gt;</code>，
        <code>&lt;select&gt;</code> 和 <code>&lt;textarea&gt;</code> 元素都将被默认设置宽度属性为 <code>width:100%</code>。
        将 <code>&lt;label&gt;</code> 元素和前面提到的表单控件包裹在 <code>.form-group</code> 中可以获得最好的排列。
    </p>
    <form>
        <div class="form-group">
            <label for="input_email">Email address</label>
            <input class="form-control" id="input_email" placeholder="Email" type="email"/>
        </div>
        <div class="form-group">
            <label for="input_pwd">Password</label>
            <input class="form-control" id="input_pwd" placeholder="Password" type="password"/>
        </div>
        <div class="form-group">
            <label for="input_file">File input</label>
            <input type="file" id="input_file">
            <p class="help-block">
                被 <code>.help-block</code> 修饰的段落是一个块级元素
            </p>
        </div>
        <div class="form-group">
            <label>
                <input type="checkbox"/> Check me out
            </label>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
