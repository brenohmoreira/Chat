package com.websocket_java.websocket_java.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class IndexResource {
    @GetMapping
    public ModelAndView index()
    {
        ModelAndView view = new ModelAndView("index");

        return view;
    }
}
