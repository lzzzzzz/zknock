package com.lz.zknock.controller.api;

import com.google.gson.Gson;
import com.lz.zknock.config.WSJSConfig;
import com.lz.zknock.entity.WSJsSession;
import com.lz.zknock.entity.normal.Result;
import com.lz.zknock.entity.normal.ResultCode;
import com.lz.zknock.entity.websocket.Message;
import com.lz.zknock.entity.websocket.MessageType;
import com.lz.zknock.entity.websocket.WSJSMessage;
import com.lz.zknock.entity.websocket.WSJSType;
import com.lz.zknock.utils.IPUtil;
import com.lz.zknock.utils.ShortTextUtil;
import com.lz.zknock.websocket.message.WsJsMessageFactory;
import com.lz.zknock.websocket.sessionpool.WSJsSessionPool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class WSJSController {

    /***
     *js-websocket消息发送
     */
    @RequestMapping(value = "/websocket/sendMessage/js-{id}", method={RequestMethod. POST})
    @ResponseBody
    public Result login(HttpServletRequest request, HttpServletResponse response, @PathVariable String id, String message) throws Exception {
        System.out.println(id);

        if(null==id||"".equals(id)||id.isEmpty()){
            return new Result(ResultCode.RESULT_ERROR,"非法请求");
        }

        String ip= IPUtil.getIpAddr(request);
        String address_test= ShortTextUtil.getShortText(WSJSConfig.MD5_SALT_STR,ip);
        WSJsSession session1= WSJsSessionPool.getSessionByAddr(address_test);//发送人
        if(!WSJsSessionPool.validate(session1)||id.equals(address_test)){
            return new Result(ResultCode.RESULT_ERROR,"非法请求");
        }

        WSJsSession session2= WSJsSessionPool.getSessionByAddr(id);//接收人
        if(!WSJsSessionPool.validate(session2)){
            return new Result(ResultCode.RESULT_ERROR,"好友不在线");
        }

        Message me=new Message(MessageType.MESSAGE_NORMAL,message);
        me.setFrom_id(address_test);
        me.setFrom_name(session1.getName());
        me.setTo_id(id);
        me.setTo_name(session2.getName());
        WSJSMessage wsMe=new WSJSMessage(WSJSType.TYPE_NORMAL,me);
        String me_str=new Gson().toJson(wsMe);
        WsJsMessageFactory.pushMessage(session1,session2,new TextMessage(me_str));
        return new Result(ResultCode.RESULT_OK,"请求成功");
    }


}  
