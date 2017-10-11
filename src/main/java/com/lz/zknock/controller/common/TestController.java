package com.lz.zknock.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {


    @RequestMapping(value=("/websocket/dbtest"),method={RequestMethod. GET})
    public ModelAndView webSocketTalk(){
        return new ModelAndView("socketTalk");
    }
}
