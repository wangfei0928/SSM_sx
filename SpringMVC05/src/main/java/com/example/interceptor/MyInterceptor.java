package com.example.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    // @RequestMapping 之前调用 false就是拦截 true放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        Object user = request.getSession().getAttribute("isLogin");
//        if (requestURI.contains("/login") || requestURI.contains("/css")) {
//            return true;
//        }

        if (user==null){
            response.sendRedirect("/login.jsp");
            return false; //当前的请求结束掉
        }

        return true;
    }

    //@RequestMapping 方法走完  起作用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //在最终响应
    }

    //@RequestMapping 方法走完 在最终响应之前起作用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //改变跳转页面
    }
}
