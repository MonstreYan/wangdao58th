package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.Salary;

public interface SalaryMapper {

    Salary selectByPrimaryKey(Integer id);

    Integer deleteByPrimaryKey(Integer id);
}
