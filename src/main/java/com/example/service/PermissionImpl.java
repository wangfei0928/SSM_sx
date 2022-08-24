package com.example.service;

import com.example.bean.Permission;
import com.example.mapper.PermissionMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionImpl implements IPermissionService{

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> getByRoleIds(List<Integer> ids) {
        return permissionMapper.getByRoleIds(ids);
    }
}
