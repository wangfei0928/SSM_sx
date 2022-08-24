package com.example.mapper;

import com.example.bean.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.print.DocFlavor;
import java.util.List;
@Mapper
public interface PermissionMapper {

    public List<Permission> getByRoleIds(@Param("ids")List<Integer> ids);
}
