package com.lz.zknock.websocket.message;

import com.lz.zknock.entity.WSJsSession;
import com.lz.zknock.websocket.sessionpool.WSJsSessionPool;
import org.springframework.web.socket.WebSocketMessage;

import java.util.ArrayList;
import java.util.List;

public class WsJsMessageFactory {

    /**单聊消息*/
    public  static WSMessageResult pushMessage(WSJsSession fromSession, WSJsSession toSession,WebSocketMessage message){
        if(WSJsSessionPool.validate(toSession)){
            try{
                toSession.getSession().sendMessage(message);
                return new WSMessageResult();
            }catch (Exception e){
                e.printStackTrace();
                return new WSMessageResult(MessageCodeConfig.RESULT_FAILED,e);
            }
        }else{
            return new WSMessageResult(MessageCodeConfig.RESULT_FAILED);
        }
    }
    /**群聊消息*/
    public  static WSMessageResult pushMessage(WSJsSession fromSession, List<WSJsSession> toSessions, WebSocketMessage message){
        if(null==toSessions||toSessions.size()<=0){
            return new WSMessageResult();
        }
        List<String> users=new ArrayList<String>();
        for(WSJsSession toSession : toSessions){
            WSMessageResult rs=pushMessage(fromSession,toSession,message);
            if(rs.getResultCode()!=MessageCodeConfig.RESULT_SUCCESS){
                users.add(toSession.getName());
            }
        }
        if(null==users||users.size()<=0){
            return new WSMessageResult();
        }else{
            return new WSMessageResult(MessageCodeConfig.RESULT_FAILED,getMessageStr(users));
        }

    }

    /**获取失败发送信息*/
    private static String getMessageStr(List<String> users){
        if(null==users||users.size()<=0){
            return "";
        }else{
            String str="";
            for(String s: users){
                str += s+";";
            }
            return str;
        }
    }
}
