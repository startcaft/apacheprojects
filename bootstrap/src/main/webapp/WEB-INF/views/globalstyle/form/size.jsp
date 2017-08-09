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

    <h2>控件尺寸</h2>
    <p>
        通过 <code>.input-lg</code> 类似的类可以为控件设置高度，通过 <code>.col-lg-*</code> 类似的类可以为控件设置宽度。
    </p>
    <hr/>

    <h2>高度尺寸</h2>
    <input class="form-control input-lg" type="text" placeholder=".input-lg"><br/>
    <input class="form-control" type="text" placeholder="Default input"><br/>
    <input class="form-control input-sm" type="text" placeholder=".input-sm"><br/>

    <select class="form-control input-lg">
        <option value="input-lg">
            .input-lg
        </option>
    </select><br/>
    <select class="form-control">
        <option value="default">
            default
        </option>
    </select><br/>
    <select class="form-control input-sm">
        <option value="input-sm">
            input-sm
        </option>
    </select><br/>
    <hr/>

    <h2>水平排列的表单组的尺寸</h2>
    <p>
        通过添加 <code>.form-group-lg</code> 或 <code>.form-group-sm</code> 类，
        为 <code>.form-horizontal</code> 包裹的 <code>&lt;label&gt;</code> 元素和表单控件设置尺寸。
    </p>
    <form class="form-horizontal">
        <div class="form-group form-group-lg">
            <label class="col-sm-2 control-label" for="formGroupInputLarge">Large label</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="formGroupInputLarge" placeholder="Large input">
            </div>
        </div>
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="formGroupInputSmall">Small label</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="formGroupInputSmall" placeholder="Small input">
            </div>
        </div>
    </form>
    <hr/>

    <h2>调整（column）尺寸</h2>
    <p2>
        用栅格系统中的列（column）包裹输入框或者任何父元素，都可以很容易的为其设置宽度
    </p2>
    <div class="row">
        <div class="col-xs-2">
            <input type="text" class="form-control" placeholder=".col-xs-2">
        </div>
        <div class="col-xs-3">
            <input type="text" class="form-control" placeholder=".col-xs-3">
        </div>
        <div class="col-xs-4">
            <input type="text" class="form-control" placeholder=".col-xs-4">
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
