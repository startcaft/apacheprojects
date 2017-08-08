<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>Bootstrap 地址</title>

  <!-- Bootstrap main css file,required -->
  <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Bootstrap theme css file,optional -->
  <link href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body style="padding: 20px">

  了解一下即可，老外的地址跟我们的地址格式不一样<br/>
  <hr/>

  <address>
    <strong>Twitter, Inc.</strong><br>
    795 Folsom Ave, Suite 600<br>
    San Francisco, CA 94107<br>
    <abbr title="Phone">P:</abbr> (123) 456-7890
  </address>

  <address>
    <strong>Full Name</strong><br>
    <a href="mailto:#">first.last@example.com</a>
  </address>

  <script src="${pageContext.request.contextPath}/statics/bootstrap/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>