package com.lz.zknock.websocket;

import com.lz.zknock.websocket.handler.WebSocketAppHandler;
import com.lz.zknock.websocket.handler.WebSocketJSHandler;
import com.lz.zknock.websocket.interceptor.WebsocketAppInterceptor;
import com.lz.zknock.websocket.interceptor.WebsocketJSInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;


@Configuration
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

    @Autowired
    private WebsocketJSInterceptor websocketJSInterceptor;
    @Autowired
    private WebSocketJSHandler webSocketJSHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        //允许使用socketJs方式访问，访问点为play，允许跨域
        registry.addHandler(webSocketJSHandler , "/zknock-js/play").addInterceptors(websocketJSInterceptor).withSockJS();

        registry.addHandler(webSocketAppHandler(),"/zknock-server/play").addInterceptors(new WebsocketAppInterceptor());

       /*
        //在topic和user这两个域上可以向客户端发消息
        registry.enableSimpleBroker("/topic","/user");
        //给指定用户发送（一对一）的主题前缀是“/user/
        registry.setApplicationDestinationPrefixes("/app");
        //客户端向服务端发送时的主题上面需要加"/app"作为前缀
        registry.setUserDestinationPrefix("/user/");
        */
    }

    @Bean
    public WebSocketJSHandler webSocketJSHandler(){
        return new WebSocketJSHandler();
    }

    @Bean
    public WebSocketAppHandler webSocketAppHandler(){
        return new WebSocketAppHandler();
    }
}
