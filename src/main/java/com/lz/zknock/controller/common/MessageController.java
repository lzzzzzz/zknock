package com.lz.zknock.controller.common;

import com.lz.zknock.entity.WSJsSession;
import com.lz.zknock.websocket.message.WsJsMessageFactory;
import com.lz.zknock.websocket.sessionpool.WSJsSessionPool;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.TextMessage;

@Controller
public class MessageController {

    @RequestMapping(value=("/websocket-js/{toid}/send"),method={RequestMethod. PUT})
    public void sendMessage(@Param("请求信息") ServerHttpRequest request,
                            @Param("请求信息") String toid,
                            @Param("要发送的信息") String message){

        if(null==message){
            return ;
        }
        if(message.length()>200){
            return;
        }
        String address= request.getRemoteAddress().getAddress().toString();
        WSJsSession session= WSJsSessionPool.getSessionByAddress(address);
        WsJsMessageFactory factory = new WsJsMessageFactory();
        factory.pushMessage(session,session,new TextMessage(message));
    }
}
