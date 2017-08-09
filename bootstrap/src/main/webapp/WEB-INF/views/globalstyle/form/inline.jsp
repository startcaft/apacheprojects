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

    <h2>内联表单</h2>
    <p>
        为 <code>&lt;form&gt;</code> 元素添加 <code>.form-inline</code> 类可使其内容左对齐并且表现为 <code>inline-block</code> 级别的控件。
        注意：适口宽度小于 768px 时会使表单折叠
    </p>
    <form class="form-inline">
        <div class="form-group">
            <label for="exampleInputName2">Name</label>
            <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">Email</label>
            <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
        </div>
        <button type="submit" class="btn btn-default">Send invitation</button>
    </form>
    <hr/>

    <p>
        一定要添加 <codel>&lt;label&gt;</codel> 标签；否则无法正确识别。对于内联表单，可以通过为 <codel>&lt;label&gt;</codel> 标签 设置
        <code>.sr-only</code> 类将其隐藏。
    </p>
    <form class="form-inline">
        <div class="form-group">
            <label class="sr-only" for="exampleInputEmail3">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail3" placeholder="Email">
        </div>
        <div class="form-group">
            <label class="sr-only" for="exampleInputPassword3">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> Remember me
            </label>
        </div>
        <button type="submit" class="btn btn-default">Sign in</button>
    </form>
    <hr/>

    <p>
        还可以使用 <code>.input-group-addon</code> 配合表单控件一起使用，组成输入框组
    </p>
    <form class="form-inline">
        <div class="form-group">
            <label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>
            <div class="input-group">
                <div class="input-group-addon">$</div>
                <input type="text" class="form-control" id="exampleInputAmount" placeholder="Amount">
                <div class="input-group-addon">.00</div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Transfer cash</button>
    </form>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
