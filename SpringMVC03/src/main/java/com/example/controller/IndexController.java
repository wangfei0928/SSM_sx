package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Controller
public class IndexController {


    /**
    *   配置欢迎界面
     * * */
//    @RequestMapping("/")
    public String index(){
        return "hello";   //走视图解析器
    }



    /**
     * springmvc的请求转发和重定向
     */
    @RequestMapping("/to1")
    public void toForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/01.jsp").forward(request,response);
    }

    @RequestMapping("/to2")
    public String to2(){
        return "forward:/01.jsp";   //如果forward:开头直接进行请求转发  不再走视图解析器
    }

    @RequestMapping("/to3")
    public InternalResourceView to3(){
        return new InternalResourceView("01.jsp");
    }

    @RequestMapping("/re1")
    public void toR1(HttpServletResponse response) throws IOException {
        response.sendRedirect("01.jsp");
    }

    @RequestMapping("/re2")
    public String toR2() {
        return "redirect:/01.jsp";
    }

    @RequestMapping("/re3")
    public RedirectView toR3() {
        return new RedirectView("/01.jsp");
    }
}
