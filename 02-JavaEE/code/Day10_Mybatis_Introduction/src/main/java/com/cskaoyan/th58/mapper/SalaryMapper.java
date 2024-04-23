package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.Salary;

import java.util.List;

public interface SalaryMapper {

    Salary selectOne(Integer id);

    List<Salary> selectAll();

    Integer insertOne(String name);

    Integer updateOne(String name);

    Integer deleteOne(Integer id);
}
