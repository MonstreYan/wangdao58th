package com.cskaoyan.th58.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {

    private Integer id;
    private String className;

    private List<Student> studentList;

}
