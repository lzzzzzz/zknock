package com.lz.zknock.websocket.interceptor;

import com.lz.zknock.entity.WSJsSession;
import com.lz.zknock.websocket.sessionpool.WSJsSessionPool;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Map;

/**JS端连接拦截器*/
@Component
public class WebsocketJSInterceptor extends HttpSessionHandshakeInterceptor {

    /*@Autowired
    private WSJsSessionService sessionService;*/

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        test(attributes);
        if(!filterAddress(request)){
            return false;
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        super.afterHandshake(request, response, wsHandler, ex);
    }

    private void test(Map<String,Object> map){
        for (Map.Entry<String, Object> entry : map.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }
    }

    /**ip地址过滤器*/
    private boolean filterAddress(ServerHttpRequest request){
        InetSocketAddress address=request.getRemoteAddress();
        if(null==address){
            return false;
        }else{
            InetAddress ia=address.getAddress();
            String hostname=address.getHostName();
            if(null==ia||null==hostname){
                return false;
            }
            System.out.println("用户："+ia.getHostAddress().toString()+"请求连接到服务器");
            WSJsSession se = WSJsSessionPool.getSessionByAddress(ia.toString());
            if(null!=se){
                return false;
            }
        }
        return true;
    }
}
