package com.example.service;

import com.example.bean.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> getByRoleIds(List<Integer> ids);
}
