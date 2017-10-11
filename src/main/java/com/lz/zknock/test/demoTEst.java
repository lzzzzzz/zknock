package com.lz.zknock.test;

import com.lz.zknock.entity.WSJsSession;
import com.lz.zknock.websocket.sessionpool.WSJsSessionPool;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.util.Map;

public class demoTEst {

    @Test
    public void test1(){
        String str= Base64.decodeBase64("192.168.02".getBytes()).toString();
        //str = ShortTextUtil.getShortText("192.168.0.1");
        System.out.println(str);
    }

    @Test
    public void testMap(){
        test(WSJsSessionPool.getAllSession());
    }

    private void test(Map<String,WSJsSession> map){
        System.out.println(map.size());
        for (Map.Entry<String, WSJsSession> entry : map.entrySet()) {

            System.out.println("Key = " + entry.getKey());

        }
    }

}
//[B@5c0369c4
//[B@5c0369c4
//[B@5c0369c4
//[B@5c0369c4
//MTkyLjE2OC4wMQ==
//MTkyLjE2OC4wMQ==
//2UEZ-BFJI-2QUV
//ZNVB-J2QZ-EJBM ==192.168.0.1
//26ZV-NURI-MNJZ == 192.168.0.2