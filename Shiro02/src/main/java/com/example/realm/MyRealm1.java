package com.example.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm1 extends AuthorizingRealm {

    private static final String USERNAME = "zhangsan"; //// 演示账号
    private static final String PASSWORD = "123"; // 演示密码
    private static final String ROLE = "admin"; // 演示账号的角色

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名查询对应的角色  通过数据库查
        //根据角色查询权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        System.out.println("进行授权");
        authorizationInfo.addRole(ROLE);
//        authorizationInfo.addStringPermissions() ; //权限
        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 将Shiro回传的参数强转成真实的具体类型，UsernamePasswordToken封装了用户输入的用户名、密码信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取用户输入的用户名 从令牌中获取
        String username = token.getUsername();
        System.out.println("re1进行认证");
        // 账号不存在
        if (!USERNAME.equals(username)) {
//            throw  new UnknownAccountException()
            return null;
        }

        // 将该用户正确的口令信息封装到认证信息对象中返回，Shiro内部会自动读取该对象完成认证
        // 这里为了演示方式直接使用演示账号，实际应该按照username到数据库中查询该用户对应的信息
        return new SimpleAuthenticationInfo(USERNAME, PASSWORD.toCharArray(), getName()); //用户名，密码，输入的用户名

    }


}
