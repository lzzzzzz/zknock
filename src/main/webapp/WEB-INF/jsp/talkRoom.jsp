<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>专属聊天室</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/chat.css" />

<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/clipboard.min.js"></script>
<script src="${pageContext.request.contextPath }/js/talkjs/flexible.js"></script>
<script src="${pageContext.request.contextPath }/js/sockjs.main.js"></script>

</head>
<body>

<header class="header">
	<a class="back" href="javascript:history.back()"></a>
	<h5 class="tit">Room</h5>
	<div class="right" data-clipboard-text="http://192.168.2.34:8081/websocket/talkjs/${room_id}"><font style="color: #5dc2f1 ">link</font></div>
</header>
<div class="message">
	<%--<div class="send">
		<div class="time">05/22 06:30</div>
		<div class="msg">
			<img src="/images/touxiang.png" alt="" />
			<p><i class="msg_input"></i>你好在不在呀，妹子！</p>
		</div>
	</div>
	<div class="show">
		<div class="time">05/22 06:30</div>
		<div class="msg">
			<img src="/images/touxiangm.png" alt="" />
			<p><i clas="msg_input"></i>你好你好你好</p>
		</div>
	</div>--%>

</div>
<div class="footer" id="dwac" wac="${pageContext.request.contextPath }/websocket/sendMessage/js-${room_id}">
	<img src="${pageContext.request.contextPath }/images/hua.png" alt="" />
	<img src="${pageContext.request.contextPath }/images/xiaolian.png" alt="" />
	<input id="kk_input" type="text"  />
	<p>发送</p>
</div>

<script src="${pageContext.request.contextPath }/js/talkjs/chat.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/talkjs/lz-webSocket.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
