package com.cskaoyan.th58.mapper;
import java.util.List;
import com.cskaoyan.th58.bean.TecCourse;

public interface TecCourseMapper {


    //展示全部的课程，但是要求：课程中可以显示哪些学生选修了这门课程
    List<TecCourse> selectAll();

    List<TecCourse> selectAll2();

}
