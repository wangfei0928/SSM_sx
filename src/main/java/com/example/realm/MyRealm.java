package com.example.realm;

import com.example.bean.Permission;
import com.example.bean.Role;
import com.example.bean.User;
import com.example.service.IPermissionService;
import com.example.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MyRealm  extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IPermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 处理角色
        String username = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名查询对应的角色  通过数据库查
        List<Role> roleList = userService.getRoleByName(username);
        List<String> roleNames = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();  //获取用户所有的角色id集合
        for (Role role : roleList) {
            roleNames.add(role.getRole());
            ids.add(role.getId());
        }
        //根据角色查询权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        System.out.println("进行授权");
        authorizationInfo.addRoles(roleNames); //把用户角色放进来



        // 处理权限
        List<Permission> permissions = permissionService.getByRoleIds(ids);
        List<String> permNames = new ArrayList<>();
        for (Permission perm : permissions) {
            permNames.add(perm.getPermission());
        }
        authorizationInfo.addStringPermissions(permNames);  //把用户权限放进来
        System.out.println("授权11111");
        return authorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 将Shiro回传的参数强转成真实的具体类型，UsernamePasswordToken封装了用户输入的用户名、密码信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取用户输入的用户名 从令牌中获取
        String username = token.getUsername();

        User user = userService.getByName(username);

        System.out.println("re1进行认证");
        // 账号不存在
        if (!user.getUsername().equals(username)) {
            throw  new UnknownAccountException();
        }


        // 将该用户正确的口令信息封装到认证信息对象中返回，Shiro内部会自动读取该对象完成认证
        // 这里为了演示方式直接使用演示账号，实际应该按照username到数据库中查询该用户对应的信息
        return new SimpleAuthenticationInfo(user.getUsername(), user.getUserpswd().toCharArray(), getName()); //用户名，密码，输入的用户名

    }
}
