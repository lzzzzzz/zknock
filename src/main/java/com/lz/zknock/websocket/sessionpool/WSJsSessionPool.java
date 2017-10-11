package com.lz.zknock.websocket.sessionpool;

import com.lz.zknock.config.WSJSConfig;
import com.lz.zknock.entity.WSJsSession;
import com.lz.zknock.utils.ShortTextUtil;
import com.lz.zknock.websocket.handler.WebSocketJSHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSJsSessionPool {

    private static Logger log = LoggerFactory.getLogger(WebSocketJSHandler.class);

    private static Map<String,WSJsSession> sessions=new HashMap<String,WSJsSession>();


    /**验证session是否有效*/
    public static boolean validate(WSJsSession session){
        if(null!=session&&null!=session.getSession()&&session.getSession().isOpen()){
            return true;
        }else{
            return false;
        }
    }

    /**保存session*/
    public static boolean putSession(WSJsSession session){
        if(null==session||null==session.getSession()||null==session.getSession().getRemoteAddress()||null==session.getSession().getRemoteAddress().getAddress()){
            return false;
        }
        String address=session.getSession().getRemoteAddress().getAddress().getHostAddress().toString();
        String address_test= ShortTextUtil.getShortText(WSJSConfig.MD5_SALT_STR,address);
        sessions.put(address_test,session);
        System.out.println("用户："+session.getName()+"连接到系统");
        log.debug("用户："+session.getName()+"连接到系统");
        System.out.println("在线用户数："+sessions.size());
        return true;
    }

    /**删除session*/
    public static boolean deleteSessionByAddress(String address){
        String address_test= ShortTextUtil.getShortText(WSJSConfig.MD5_SALT_STR,address);
        if(null==address_test){
            return false;
        }
        sessions.remove(address_test);
        System.out.println("用户："+address+"退出到系统");
        System.out.println("在线用户数："+sessions.size());
        return true;
    }

    /**删除session*/
    public static boolean deleteSessionByAddress(WSJsSession session){
        if(null==session||null==session.getSession()||null==session.getSession().getRemoteAddress()||null==session.getSession().getRemoteAddress().getAddress()){
            return false;
        }
        String address=session.getSession().getRemoteAddress().getAddress().toString();
        String address_test= ShortTextUtil.getShortText(WSJSConfig.MD5_SALT_STR,address);

        if(null==address_test){
            return false;
        }
        sessions.remove(address_test);
        System.out.println("用户："+address+"退出到系统");
        System.out.println("在线用户数："+sessions.size());
        return true;
    }

    public static Map<String,WSJsSession> getAllSession(){
        return sessions;
    }

    /**根据ip地址获取session
     * @param address 转换前的地址
     * */
    public static WSJsSession getSessionByAddress(String address){
        String address_test= ShortTextUtil.getShortText(WSJSConfig.MD5_SALT_STR,address);
        return sessions.get(address);
    }

    /**根据ip地址获取session
     * @param address 转换后的地址
     * */
    public static WSJsSession getSessionByAddr(String address){
        //String address_test= ShortTextUtil.getShortText(WSJSConfig.MD5_SALT_STR,address);
        return sessions.get(address);
    }

    /**获取订阅列表session*/
    public static Map<String,WSJsSession> getSessionsByAddrs(List<String> addrs){
        if(null==addrs||addrs.size()<=0){
            return null;
        }
        Map<String,WSJsSession> get_session=new HashMap<String,WSJsSession>();
        for(String addess : addrs){
            String address_test= ShortTextUtil.getShortText(WSJSConfig.MD5_SALT_STR,addess);
            if(null!=address_test){
                get_session.put(addess,getSessionByAddress(address_test));
            }
        }
        return get_session;
    }

}
