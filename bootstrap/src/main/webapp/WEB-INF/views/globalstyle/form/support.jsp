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

    <h2>输入框</h2>
    <p>
        包括大部分表单控件，文本输入域控件，还支持所有 HTML5 类型的输入控件：
        <code>&lt;text&gt;</code>，<code>&lt;password&gt;</code>，<code>&lt;datetime&gt;</code>，
        <code>&lt;datetime-local&gt;</code>，<code>&lt;date&gt;</code>，<code>&lt;month&gt;</code>，
        <code>&lt;time&gt;</code>，<code>&lt;week&gt;</code>，<code>&lt;number&gt;</code>，
        <code>&lt;url&gt;</code>，<code>&lt;search&gt;</code>，<code>&lt;tel&gt;</code> 和 <code>&lt;color&gt;</code>。
    </p>
    <input type="text" class="form-control" placeholder="Text input">
    <hr/>

    <h2>文本域</h2>
    <p>
        支持多行文本的表单控件。可根据需要改变 <code>rows</code> 属性
    </p>
    <textarea class="form-control" rows="3"></textarea>
    <hr/>

    <h2>多选或单选框</h2>
    <p>
        默认外观（堆叠在一起）
    </p>
    <div class="checkbox">
        <label>
            <input type="checkbox" value="">
            Option one is this and that&mdash;be sure to include why it's great
        </label>
    </div>
    <div class="checkbox disabled">
        <label>
            <input type="checkbox" value="" disabled>
            Option two is disabled
        </label>
    </div>

    <div class="radio">
        <label>
            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
            Option one is this and that&mdash;be sure to include why it's great
        </label>
    </div>
    <div class="radio">
        <label>
            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
            Option two can be something else and selecting it will deselect option one
        </label>
    </div>
    <div class="radio disabled">
        <label>
            <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3" disabled>
            Option three is disabled
        </label>
    </div>
    <h2>内联表单和多选框</h2>
    <p>
        通过将 <code>.checkbox-inline</code> 或 <code>.radio-inline</code> 类应用到一系列的多选框或单选框控件上，
        可以使这些控件排列在一行。
    </p>
    <label class="checkbox-inline">
        <input type="checkbox" id="inlineCheckbox1" value="option1"> 1
    </label>
    <label class="checkbox-inline">
        <input type="checkbox" id="inlineCheckbox2" value="option2"> 2
    </label>
    <label class="checkbox-inline">
        <input type="checkbox" id="inlineCheckbox3" value="option3"> 3
    </label>

    <label class="radio-inline">
        <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 1
    </label>
    <label class="radio-inline">
        <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 2
    </label>
    <label class="radio-inline">
        <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> 3
    </label>
    <hr/>

    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
