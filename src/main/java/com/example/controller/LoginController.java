package com.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(String uname,String password){

        Subject user = SecurityUtils.getSubject();//得到主体
        //测试session

        user.getSession().setAttribute("session","I am login session");


        UsernamePasswordToken token = new UsernamePasswordToken(uname, password);

        token.setRememberMe(true);
        try {
            boolean remembered = user.isRemembered();
            System.out.println(remembered);
            token.setRememberMe(true);
            if (!user.isAuthenticated()){
                System.out.println("我要认证了");
                user.login(token);

            }

            return "redirect:/index";// 登录成功，去主页
        } catch (UnknownAccountException e) {
            System.out.println("账号不存在！");
        } catch (LockedAccountException e) {
            System.out.println("账号已被锁定！");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误！");
        } catch (AuthenticationException e) {
            // 其他认证异常
            System.out.println("登陆失败");
            e.printStackTrace();
            return "redirect:/login.jsp"; // 登录失败回到登录页
        }
        return "redirect:/login.jsp";
    }
}
