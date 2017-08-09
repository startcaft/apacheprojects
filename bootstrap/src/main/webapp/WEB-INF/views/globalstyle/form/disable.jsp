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

    <h2>禁用状态</h2>
    <p>
        为输入框设置 <code>disable</code> 属性可以禁止其与用户有任何交互（焦点，输入等），被禁用的输入框颜色更浅了，并且还添加了 <code>not-allowed</code> 鼠标状态
    </p>
    <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input here..." disabled>
    <hr/>

    <h2>被禁用的 fieldset</h2>
    <p>
        为 <code>&lt;fieldset&gt;</code> 设置 <code>disable</code> 属性，可以禁用 <code>&lt;fieldset&gt;</code> 中包含的所有控件。
        <code>&lt;a&gt;</code> 标签的链接功能不受影响。
        但是 IE 11 有兼容性问题，建议使用 js 带禁用 <code>&lt;fieldset&gt;</code> 。
    </p>

    <form role="form">
        <fieldset disabled>
            <div class="form-group">
                <label for="disabledTextInput">Disabled input</label>
                <input type="text" id="disabledTextInput" class="form-control" placeholder="Disabled input">
            </div>
            <div class="form-group">
                <label for="disabledSelect">Disabled select menu</label>
                <select id="disabledSelect" class="form-control">
                    <option>Disabled select</option>
                </select>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Can't check this
                </label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </fieldset>
    </form>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
