package com.lz.zknock.controller.common;

import com.google.gson.Gson;
import com.lz.zknock.config.WSJSConfig;
import com.lz.zknock.entity.WSJsSession;
import com.lz.zknock.entity.websocket.Message;
import com.lz.zknock.entity.websocket.MessageType;
import com.lz.zknock.entity.websocket.WSJSMessage;
import com.lz.zknock.entity.websocket.WSJSType;
import com.lz.zknock.utils.IPUtil;
import com.lz.zknock.utils.ShortTextUtil;
import com.lz.zknock.websocket.message.WSMessageResult;
import com.lz.zknock.websocket.message.WsJsMessageFactory;
import com.lz.zknock.websocket.sessionpool.WSJsSessionPool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {

    @RequestMapping(value=("/websocket/socketTalk"),method={RequestMethod. GET})
    public ModelAndView webSocketTalk(){
        return new ModelAndView("socketTalk");
    }

    @RequestMapping(value=("/websocket/talkRoom"),method={RequestMethod. GET})
    public ModelAndView wsCreateTalkRoom(HttpServletRequest request, HttpServletResponse response){

        String ip= IPUtil.getIpAddr(request);
        String address_test= ShortTextUtil.getShortText(WSJSConfig.MD5_SALT_STR,ip);
        WSJsSession session= WSJsSessionPool.getSessionByAddr(address_test);
        if(!WSJsSessionPool.validate(session)){
            request.getSession().setAttribute("room_id",address_test);
            return new ModelAndView("talkRoom");
        }else{
            return new ModelAndView("error");
        }


    }

    @RequestMapping(value=("/websocket/talkjs/{id}"),method={RequestMethod. GET})
    public ModelAndView webSocketTalkRoom(HttpServletRequest request, HttpServletResponse response, @PathVariable String id){

        String ip= IPUtil.getIpAddr(request);
        String address_test= ShortTextUtil.getShortText(WSJSConfig.MD5_SALT_STR,ip);

        if(id.equals(address_test)){
            request.getSession().setAttribute("message","您已进入过房间");
            return new ModelAndView("error");
        }

        WSJsSession session= WSJsSessionPool.getSessionByAddr(address_test);

        if(WSJsSessionPool.validate(session)){
            request.getSession().setAttribute("message","您已进入过房间");
            return new ModelAndView("error");
        }

        request.getSession().setAttribute("room_id",id);
        WSJsSession session2= WSJsSessionPool.getSessionByAddr(id);
        Message me=new Message(MessageType.MESSAGE_NORMAL,"有朋友准备加入房间");
        WSJSMessage wsMe=new WSJSMessage(WSJSType.TYPE_BRODCAST,me);
        String me_str=new Gson().toJson(wsMe);
        WSMessageResult wr = WsJsMessageFactory.pushMessage(null,session2,new TextMessage(me_str));
        System.out.println("wr:"+wr.getResultCode());
        return new ModelAndView("talkRoom");
    }

    @RequestMapping(value=("/websocket/login"),method={RequestMethod. GET})
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){

        return new ModelAndView("login");
    }
}
