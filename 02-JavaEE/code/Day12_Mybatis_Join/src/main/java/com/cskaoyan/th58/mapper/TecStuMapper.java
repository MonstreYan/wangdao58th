package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.TecStu;

import java.util.List;

public interface TecStuMapper {


    List<TecStu> selectByCourseId(Integer courseId);

    //新增的部分
    //展示所有的学生信息，每个学生需要关联选修的课程
    List<TecStu> selectAll();

    List<TecStu> selectAll2();
}
