package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.Account;
import com.cskaoyan.th58.bean.Salary;
import org.apache.ibatis.annotations.Param;

public interface SalaryMapper {

    Salary selectOneById(Integer id);

    Salary selectOneByName(String name);


    Salary selectOneById2(@Param("id") Integer param);


    Salary selectByNameAndSalary(@Param("name") String nm,@Param("salary") Double sl);


    void insertOne(Salary salary);

    void insertOne2(@Param("s") Salary salary);


    void insertOne3(@Param("s") Salary salary,@Param("a") Account account);

}
