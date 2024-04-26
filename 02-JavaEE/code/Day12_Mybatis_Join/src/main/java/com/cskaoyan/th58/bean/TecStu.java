package com.cskaoyan.th58.bean;

import lombok.Data;

import java.util.List;

@Data
public class TecStu {
    private Integer id;
    private String name;

    //新增的部分
    private List<TecCourse> courseList;

}
