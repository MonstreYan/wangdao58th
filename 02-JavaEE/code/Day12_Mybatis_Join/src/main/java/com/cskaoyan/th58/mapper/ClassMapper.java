package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.Clazz;

import java.util.List;

public interface ClassMapper {

    //我们去查询全部的班级，但是要求可以在当前班级中显示所有的学生信息
    List<Clazz> selectAll();

    List<Clazz> selectAll2();
}
