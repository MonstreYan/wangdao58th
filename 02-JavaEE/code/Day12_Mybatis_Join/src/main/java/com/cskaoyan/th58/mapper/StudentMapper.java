package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> selectByClasIds(Integer classId);
}
