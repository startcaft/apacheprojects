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

    <h2>静态控件</h2>
    <p>
        如果需要在表单中将一行 纯文本 和 <code>&lt;label&gt;</code> 元素放置于同一行，为 <code>&lt;p&gt;</code> 元素添加 <code>.form-control-static</code> 类即可。
    </p>
    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <p class="form-control-static">email@example.com</p>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword" placeholder="Password">
            </div>
        </div>
    </form>
    <hr/>

    <form class="form-inline">
        <div class="form-group">
            <label class="sr-only">Email</label>
            <p class="form-control-static">email@example.com</p>
        </div>
        <div class="form-group">
            <label for="inputPassword2" class="sr-only">Password</label>
            <input type="password" class="form-control" id="inputPassword2" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-default">Confirm identity</button>
    </form>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
