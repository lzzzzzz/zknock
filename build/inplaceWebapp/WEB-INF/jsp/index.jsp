<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>welcome</title>

<script src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css"/>

<style>
/* base.scss */

</style>

</head>
<body>

<div class="wrap flex-c-c">
  <form action="" method="" class="flex-c-c">
    <ul class="select__list">
      <li id="js-usr-rtn" class="select__label">登录</li>
      <li id="js-usr-new" class="select__label select__label--active">注册</li>
      <li id="js-usr-rst" class="select__label">忘记密码</li>
    </ul>
    <span class="pointer"></span>
    <input type="email" placeholder="邮箱" class="ui-field" id="js-field__email" />
    <input type="password" placeholder="密码" class="ui-field" id="js-field__pass" />
    <input type="password" placeholder="确认密码" class="ui-field" id="js-field__r-pass" />
    <button id="js-btn" class="ui-button --usr-new"></button>
  </form>
</div>
<script src="js/login.js"></script>
</body>
</html>

