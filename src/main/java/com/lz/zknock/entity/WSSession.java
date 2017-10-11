package com.lz.zknock.entity;

import org.springframework.web.socket.WebSocketSession;

import java.io.Serializable;

/**app端session会话*/
public class WSSession implements Serializable{

    private String id;

    /**app端 websocket-session会话*/
    private WebSocketSession session;

    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
