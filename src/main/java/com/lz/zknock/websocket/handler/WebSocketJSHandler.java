package com.lz.zknock.websocket.handler;

import com.lz.zknock.entity.WSJsSession;
import com.lz.zknock.utils.ChineseNameUtils;
import com.lz.zknock.websocket.sessionpool.WSJsSessionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * js连接客户端
 * */
@Component
public class WebSocketJSHandler implements WebSocketHandler {

    private Logger log = LoggerFactory.getLogger(WebSocketJSHandler.class);

    /*@Autowired
    private WSJsSessionServiceImpl sessionService;*/

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.debug("ConnectionEstablished==>>"+getSessionInfo(session));
        addUser(session);
        //System.out.println("name:"+sessionService.get(session.getRemoteAddress().getAddress().toString()).getName());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.debug("handleMessage" + message.toString());
        //sendMessageToUsers();
        session.sendMessage(new TextMessage(new Date() + ""));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        delUser(session);//删除连接出错的用户
        System.out.println("用户连接出错==>" + exception.getMessage());
        log.debug("handleTransportError" + exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        delUser(session);
        System.out.println("用户连接关闭Reason==>" +closeStatus.getCode());
        log.debug("afterConnectionClosed Reason->" +closeStatus.getReason());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     *
     * @parammessage
     */
    /*public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    private boolean filterAddress(ServerHttpRequest request){
        InetSocketAddress address=request.getRemoteAddress();
        if(null==address){
            return false;
        }else{
            InetAddress ia=address.getAddress();
            if(null==ia){
                return false;
            }
            WSJsSession se = WSJsSessionPool.getSessionByAddress(ia.toString());
            if(null==se){
                return false;
            }
        }
        return true;
    }

    /**添加建立连接的用户*/
    private boolean addUser(WebSocketSession session){
        try{
            if(null!=session){
                InetAddress address =session.getRemoteAddress().getAddress();
                if(null!=address){
                    String address_str=address.toString();
                    if(null!=address_str&&!"".equals(address_str)&&!address_str.isEmpty()){
                        WSJsSession jsSession=new WSJsSession();
                        jsSession.setName(ChineseNameUtils.getName());
                        jsSession.setToken("123456");
                        jsSession.setSession(session);
                        return WSJsSessionPool.putSession(jsSession);//保存建立连接的用户
                    }
                }
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    /**删除关闭连接的用户*/
    private void delUser(WebSocketSession session){
        if(null!=session){
            InetAddress address=session.getRemoteAddress().getAddress();
            if(null!=address){
                WSJsSessionPool.deleteSessionByAddress(address.toString());//关闭断开连接的用户
                System.out.println("用户:"+address.toString()+"关闭连接");
                log.debug("afterConnectionClosed->" + getSessionInfo(session));
            }
        }
    }

    /**获取连接信息*/
    private String getSessionInfo(WebSocketSession session){
        if(null==session){
            return "null";
        }
        String sessionInfo="{";
        String id=session.getId();
        String uri=session.getUri().toString();
        sessionInfo +="id:"+sessionInfo+";"+"uri:"+uri+";";
        if(null!=session.getPrincipal()){
            String principal_name = session.getPrincipal().getName();
            sessionInfo +="Principal_name:"+principal_name+";";
        }
        if(null!=session.getRemoteAddress()){
            String address = "address" + session.getRemoteAddress().getHostName()+"->"+session.getRemoteAddress().getAddress()+":"+session.getRemoteAddress().getPort();
            sessionInfo +="{address:"+address+"};";
        }
        sessionInfo += "}";
        return sessionInfo;
    }

}
