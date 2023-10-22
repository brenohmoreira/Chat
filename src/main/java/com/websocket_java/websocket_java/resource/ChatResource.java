package com.websocket_java.websocket_java.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/chat")
public class ChatResource {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView chat()
    {
        ModelAndView view = new ModelAndView("chat");

        return view;
    }
}
