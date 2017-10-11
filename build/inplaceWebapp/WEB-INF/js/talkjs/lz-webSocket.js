var url = "http://192.168.2.34:8081/zknock-js/play";
var websocket = null;
/*if ('WebSocket' in window) {
    websocket = new WebSocket(url);
} else {*/
    websocket = new SockJS(url);
//}
websocket.onopen = onOpen;
websocket.onmessage = onMessage;
websocket.onerror = onError;
websocket.onclose = onClose;

function onOpen(openEvent) {
    console.log("openEvent");
    //document.getElementById("console").innerHTML = document.getElementById("console").innerHTML+ "OPEN<br/>";
}

function onMessage(event) {
    //var sss="{\"type\":\"message\",\"bubbles\":false,\"cancelable\":false,\"timeStamp\":1504771813089,\"data\":\"{\\\"type\\\":3,\\\"result_code\\\":0,\\\"message\\\":{\\\"type\\\":1,\\\"message\\\":\\\"有朋友准备加入房间\\\"}}\"}";
    console.log("onMessage:"+JSON.stringify(event));
    var data=JSON.parse(event.data)
        var message=data.message;
        //console.log("event.data.message:"+JSON.stringify(message));
        if(data.type==1){
            var fid=message.from_id;
            var old_action=$("#dwac").attr("wac");
            var tmp=old_action.substring(old_action.lastIndexOf("/")+1,old_action.length);
            var new_action=old_action.replace(tmp,"")+"js-"+fid;
            $("#dwac").attr("wac",new_action);
            //console.log("new_action"+new_action);
            send("/images/touxiang.png",message.message);
        }
    //document.getElementById("console").innerHTML = document.getElementById("console").innerHTML+ event.data+"<br/>";
}
function onError() {
    console.log("onError");
}
function onClose() {
    console.log("onClose");
}

/*function doSend() {
    console.log(websocket.readyState);
    if (websocket.readyState == SockJS.OPEN) {
        var msg = document.getElementById("message").value;
        websocket.send(msg);
    } else {
        alert("连接失败!");
    }
}*/


function disconnect(){
    if (websocket != null) {
        websocket.close();
        websocket = null;
    }
}

function reconnect(){
    if (websocket != null) {
        websocket.close();
        websocket = null;
    }
    // if ('WebSocket' in window) {
    //     websocket = new WebSocket(url);
    // } else {
        websocket = new SockJS( url);
    //}
    websocket.onopen = onOpen;
    websocket.onmessage = onMessage;
    websocket.onerror = onError;
    websocket.onclose = onClose;
}