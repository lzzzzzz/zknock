package com.lz.zknock.test;

import com.lz.zknock.dao.WSUserDao;
import com.lz.zknock.entity.WSUser;
import com.lz.zknock.entity.WSJsSession;
import com.lz.zknock.service.WSUserService;
import com.lz.zknock.websocket.message.WSMessageResult;
import com.lz.zknock.websocket.message.WsJsMessageFactory;
import com.lz.zknock.websocket.sessionpool.WSJsSessionPool;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.socket.TextMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
        //"classpath:spring/spring-web.xml"
})
public class SessionTest {

    @Autowired
    WSUserService userService;

    @Autowired
    private WSUserDao wsjsUserDao;

    @Test
    public void test2() throws Exception{
        /*ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/websocket/dbtest"));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);*/
        List<WSUser> users = wsjsUserDao.getAllUser();
        System.out.println(null==users?"wsjsUserDao is null":users.size());
    }

    @Test
    public void test3() throws Exception{
        WSJsSession session= WSJsSessionPool.getSessionByAddr("3YEQ-BJUI-ZEMV");
        System.out.println("session is null?"+(null==session?true:false));
        System.out.println("number:"+WSJsSessionPool.getAllSession().size());
        WSMessageResult WWR= WsJsMessageFactory.pushMessage(null,session,new TextMessage("测试"));
    }
}
