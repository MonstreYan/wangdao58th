package com.cskaoyan.tx.multiTransfer;

import java.util.List;

public class MultiTransferMoney {

    public static void main(String[] args) {
        //首先需要做的事情先获取每个员工的薪资
        //查询salary表，获取每个人对应的薪水
        //因为下面这部分代码有些太过于繁琐，我们希望可以封装简化，抽提一个工具类来操作
        //在我们的主业务代码中，滤清业务流程会比较的顺
        List<Employee> employeeList = TransferService.getEmployeeList();

        //随后进行转账
        TransferService.transfer(employeeList);
    }
}
