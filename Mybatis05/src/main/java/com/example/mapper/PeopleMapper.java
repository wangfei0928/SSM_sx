package com.example.mapper;

import com.example.bean.People;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleMapper {

    public void insertMany(@Param("plist")List<People> list);

    public List<People> getAll();
}
