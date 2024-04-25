package com.cskaoyan.th58.bean;

import lombok.Data;

import java.util.List;

@Data
public class TecCourse {

    private Integer id;
    private String name;

    List<TecStu> studentList;
}
