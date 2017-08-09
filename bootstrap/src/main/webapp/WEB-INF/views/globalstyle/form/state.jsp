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

    <h2>校验状态</h2>
    <p>
        Bootstrap 对表单控件的校验状态，都定义了相关样式。使用时，添加 <code>.has-warning</code>，
        <code>.has-error</code> 或 <code>.has-success</code> 类到表单控件的父级元素即可。
        任何包含在元素之内的 <code>.control-label</code>，<code>.form-control</code> 和 <code>.help-block</code>
        元素都将接受这些校验状态的样式。
    </p>
    <div class="form-group has-success">
        <label class="control-label" for="inputSuccess1">Input with success</label>
        <input type="text" class="form-control" id="inputSuccess1" aria-describedby="helpBlock2">
        <span id="helpBlock2" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
    </div>
    <div class="form-group has-warning">
        <label class="control-label" for="inputWarning1">Input with warning</label>
        <input type="text" class="form-control" id="inputWarning1">
    </div>
    <div class="form-group has-error">
        <label class="control-label" for="inputError1">Input with error</label>
        <input type="text" class="form-control" id="inputError1">
    </div>
    <div class="has-success">
        <div class="checkbox">
            <label>
                <input type="checkbox" id="checkboxSuccess" value="option1">
                Checkbox with success
            </label>
        </div>
    </div>
    <div class="has-warning">
        <div class="checkbox">
            <label>
                <input type="checkbox" id="checkboxWarning" value="option1">
                Checkbox with warning
            </label>
        </div>
    </div>
    <div class="has-error">
        <div class="checkbox">
            <label>
                <input type="checkbox" id="checkboxError" value="option1">
                Checkbox with error
            </label>
        </div>
    </div>
    <hr/>

    <h2>添加额外的图标</h2>
    <p>
        还可以针对校验状态为输入框添加额外的图标。只需设置相应的 <code>.has-feedback</code> 类即可添加正确的图标。
    </p>
    <div class="form-group has-success has-feedback">
        <label class="control-label" for="inputSuccess2">Input with success</label>
        <input type="text" class="form-control" id="inputSuccess2" aria-describedby="inputSuccess2Status">
        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        <span id="inputSuccess2Status" class="sr-only">(success)</span>
    </div>
    <div class="form-group has-warning has-feedback">
        <label class="control-label" for="inputWarning2">Input with warning</label>
        <input type="text" class="form-control" id="inputWarning2" aria-describedby="inputWarning2Status">
        <span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
        <span id="inputWarning2Status" class="sr-only">(warning)</span>
    </div>
    <div class="form-group has-error has-feedback">
        <label class="control-label" for="inputError2">Input with error</label>
        <input type="text" class="form-control" id="inputError2" aria-describedby="inputError2Status">
        <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
        <span id="inputError2Status" class="sr-only">(error)</span>
    </div>
    <div class="form-group has-success has-feedback">
        <label class="control-label" for="inputGroupSuccess1">Input group with success</label>
        <div class="input-group">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" id="inputGroupSuccess1" aria-describedby="inputGroupSuccess1Status">
        </div>
        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        <span id="inputGroupSuccess1Status" class="sr-only">(success)</span>
    </div>
    <hr/>

    <h2>为水平排列的表单和内联表单设置可选的图标</h2>
    <form class="form-horizontal">
        <div class="form-group has-success has-feedback">
            <label class="control-label col-sm-3" for="inputSuccess3">Input with success</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="inputSuccess3" aria-describedby="inputSuccess3Status">
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                <span id="inputSuccess3Status" class="sr-only">(success)</span>
            </div>
        </div>
        <div class="form-group has-success has-feedback">
            <label class="control-label col-sm-3" for="inputGroupSuccess2">Input group with success</label>
            <div class="col-sm-9">
                <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <input type="text" class="form-control" id="inputGroupSuccess2" aria-describedby="inputGroupSuccess2Status">
                </div>
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                <span id="inputGroupSuccess2Status" class="sr-only">(success)</span>
            </div>
        </div>
    </form>
    <hr/>
    <form class="form-inline">
        <div class="form-group has-success has-feedback">
            <label class="control-label" for="inputSuccess4">Input with success</label>
            <input type="text" class="form-control" id="inputSuccess4" aria-describedby="inputSuccess4Status">
            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
            <span id="inputSuccess4Status" class="sr-only">(success)</span>
        </div>
    </form>
    <form class="form-inline">
        <div class="form-group has-success has-feedback">
            <label class="control-label" for="inputGroupSuccess3">Input group with success</label>
            <div class="input-group">
                <span class="input-group-addon">@</span>
                <input type="text" class="form-control" id="inputGroupSuccess3" aria-describedby="inputGroupSuccess3Status">
            </div>
            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
            <span id="inputGroupSuccess3Status" class="sr-only">(success)</span>
        </div>
    </form>
    <hr/>

    <h2>可选的图标与设置的 <code>.sr-only</code> 类的 <code>&lt;label&gt;</code></h2>
    <div class="form-group has-success has-feedback">
        <label class="control-label sr-only" for="inputSuccess5">Hidden label</label>
        <input type="text" class="form-control" id="inputSuccess5" aria-describedby="inputSuccess5Status">
        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        <span id="inputSuccess5Status" class="sr-only">(success)</span>
    </div>
    <div class="form-group has-success has-feedback">
        <label class="control-label sr-only" for="inputGroupSuccess4">Input group with success</label>
        <div class="input-group">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" id="inputGroupSuccess4" aria-describedby="inputGroupSuccess4Status">
        </div>
        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        <span id="inputGroupSuccess4Status" class="sr-only">(success)</span>
    </div>
    <hr/>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
