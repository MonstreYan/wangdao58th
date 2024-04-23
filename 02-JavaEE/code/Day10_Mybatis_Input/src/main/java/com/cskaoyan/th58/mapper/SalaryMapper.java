package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.Salary;
import org.apache.ibatis.annotations.Param;

public interface SalaryMapper {

    Salary selectOneById(Integer id);

    Salary selectOneByName(String name);


    Salary selectOneById2(@Param("id") Integer param);
}
