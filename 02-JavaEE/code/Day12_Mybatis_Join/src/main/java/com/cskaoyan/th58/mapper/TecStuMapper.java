package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.TecStu;

import java.util.List;

public interface TecStuMapper {


    List<TecStu> selectByCourseId(Integer courseId);
}
