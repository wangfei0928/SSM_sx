package com.example.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import java.util.Arrays;
import java.util.List;

public class ShiroTest {
    public static void main(String[] args) {
        String name = "zhangsan";  //UnknownAccountException   账号错误
        String pwd = "123456";   //IncorrectCredentialsException  密码错误

        //读取配置文件 代替了数据库和realm
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-t.ini");

        //得到安全管理器
        SecurityManager securityManager = factory.getInstance();
        //通过安全工具  得到我们的subject
        SecurityUtils.setSecurityManager(securityManager);
        //得到当前用户  主体
        Subject user = SecurityUtils.getSubject();

        //是否进行过认证
        boolean authenticated = user.isAuthenticated();
        System.out.println("login之前："+authenticated);

        //生成了一个令牌
        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);

        //登陆操作
        user.login(token);

        boolean authenticated1 = user.isAuthenticated();
        System.out.println("login之后："+authenticated1);


        boolean istercher = user.hasRole("teacher");
        boolean isstudent = user.hasRole("student");
        System.out.println(name+"是否有老师角色:"+istercher);
        System.out.println(name+"是否有学生角色:"+isstudent);

        List<String> list = Arrays.asList("teacher", "student");
        boolean allRoles = user.hasAllRoles(list);
        System.out.println("是否有老师和学生两个角色:"+allRoles);

        boolean permitted = user.isPermitted("看电影");
        System.out.println("是否有看电影权限"+permitted);

        boolean userPermitted = user.isPermitted("study语文");
        System.out.println("是否有学习语文的权限"+userPermitted);

        //Session的使用
        Session session = user.getSession();
        session.setAttribute("session","hello shiro");
        Object session1 = session.getAttribute("session");
        System.out.println(session1);


        user.logout();
        System.out.println("退出后:"+user.isAuthenticated());
        Object session2 = session.getAttribute("session");
        System.out.println(session2);
    }
}
