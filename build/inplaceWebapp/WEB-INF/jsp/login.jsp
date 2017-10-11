<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>welcome</title>

<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/login.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css"/>

<style>
/* base.scss */

</style>

</head>
<body>
<div class="htmleaf-container">
  <p class="center">welcome</p>
  <p class="center"></p>
  <div id="wrapper" class="login-page">
    <div id="login_form" class="form">
      <form class="register-form">
        <input type="text" placeholder="用户名" id="r_user_name"/>
        <input type="password" placeholder="密码" id="r_password" />
        <input type="text" placeholder="电子邮件" id="r_emial"/>
        <button id="create">创建账户</button>
        <p class="message">已经有了一个账户? <a href="#">立刻登录</a></p>
      </form>
      <form class="login-form">
        <input type="text" placeholder="用户名" id="user_name"/>
        <input type="password" placeholder="密码" id="password"/>
        <button id="login">登　录</button>
        <p class="message">还没有账户? <a href="#">立刻创建</a></p>
      </form>
    </div>
  </div>
</div>
</body>
</html>

