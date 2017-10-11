<%--
  Created by IntelliJ IDEA.
  User: manyi
  Date: 17-8-9
  Time: 下午12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSocket/SockJS Echo Sample (Adapted from Tomcat's echo sample)</title>
    <script src="${pageContext.request.contextPath }/js/sockjs.main.js"></script>

    <script type="text/javascript">
        /*var  wsServer = 'ws://127.0.0.1:8080/test/hello';
        var  websocket = new WebSocket(wsServer);
        websocket.onopen = function (evt) { onOpen(evt) };
        websocket.onclose = function (evt) { onClose(evt) };
        websocket.onmessage = function (evt) { onMessage(evt) };
        websocket.onerror = function (evt) { onError(evt) };
        function onOpen(evt) {
           console.log("Connected to WebSocket server.");
        }
        function onClose(evt) {
           console.log("Disconnected");
        }
        function onMessage(evt) {
           console.log('Retrieved data from server: ' + evt.data);
        }
        function onError(evt) {
           console.log('Error occured: ' + evt.data);
        }*/
        var sock = new SockJS('http://192.168.2.34:8081/zknock-js/play');
        sock.onopen = function() {
            console.log('open');
            sock.send('哈哈哈哈哈哈');
            setTimeout(function(){sock.send('later');},3000);
        };
        sock.onmessage = function(e) {

            console.log('message', e.data);
        };
        /*sock.onclose = function() {
            console.log('close');
        };*/
    </script>
</head>
<body>

</body>
</html>
