package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.servlet.http.HttpSession;

@Controller
public class ToPageController {

    @RequestMapping("/to1")
    public ModelAndView fn1(){
        ModelAndView modelAndView = new ModelAndView("to1");
        //就是把参数放到request的范围中
        modelAndView.addObject("reqto1","hello world");
        return modelAndView;//相当于请求转发
    }

    @RequestMapping("/to2")
    public String fn2(Model model, ModelMap modelMap, HttpSession session){
        model.addAttribute("reqto2","hello world2");  //也是放在了request的范围
        modelMap.addAttribute("reqmapto2","hello3");  //也是放在了request的范围
        session.setAttribute("reqmapto2","hello3");
        return "to2"; //和modelAndView一样，走的时视图解析器
    }
}
