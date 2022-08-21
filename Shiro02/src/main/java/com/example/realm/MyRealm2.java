package com.example.realm;

import com.example.bean.AuthenMsg;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm2  extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 将Shiro回传的参数强转成真实的具体类型，UsernamePasswordToken封装了用户输入的用户名、密码信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取用户输入的用户名 从令牌中获取
        String username = token.getUsername();
        System.out.println("re2进行认证");

        AuthenMsg msg = new AuthenMsg();

        if (!username.equals(msg.getName())){
            return null;
        }

        return new SimpleAuthenticationInfo(msg.getName(), msg.getPwd().toCharArray(), getName()); //用户名，密码，输入的用户名

    }
}
