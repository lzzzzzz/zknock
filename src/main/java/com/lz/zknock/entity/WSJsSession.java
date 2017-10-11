package com.lz.zknock.entity;

import org.springframework.web.socket.WebSocketSession;

import java.io.Serializable;

/**js-session会话*/
public class WSJsSession implements Serializable{

    private String name;

    /**websocket-session会话*/
    private WebSocketSession session;

    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
