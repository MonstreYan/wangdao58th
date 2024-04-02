package com.cskaoyan._19collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目一：学生名单管理
 * <p>
 * 假设你是一位老师，需要管理你班级的学生名单。
 * 请编写一个程序，使用ArrayList来实现学生名单的管理，包括添加学生、删除学生和显示学生名单。要求如下：
 * <p>
 * 创建一个空的ArrayList对象来存储学生名单。
 * 提示用户输入学生的姓名，并将其添加到学生名单中。
 * 提供一个选项，允许用户从学生名单中删除某个学生。
 * 提供一个选项，允许用户显示当前的学生名单。
 * 提供一个选项，允许用户退出程序。
 * 提示：使用Scanner类来接收用户输入。
 * <p>
 * 需求返讲。
 * 要实现一个功能， 允许添加学生，删除学生，显示学生。 可以循环操作。
 *
 * TODO： 按照新的理解，再做一做。
 * 问题：
 * 1.现在退出了系统，输入的信息都没了。 如果想数据，持久保存。
 * IO流。 退出系统的时候，可以用输出流，将数据写入到文件； 启动程序的时候，将文件加载进来。
 * 2.如果用户的信息很多， 比如有id， name， age，address。现在需要存储这些数据。
 * 1） 怎么输入？ 一行   "1,张三,18,hubei"  split(",")  Integer.parseInt()
 * 2) 怎么存储？  类。
 * 3.学生数据，怎么存到外面去。 （磁盘上）。 List<Student>
 *     序列化。 反序列化。  无所谓。
 *     Student{id=1, name=zhangsan, age=18, address=hubei}
 *     Student{id=2, name=lisi, age=18, address=hubei}
 *     Student{id=3, name=wangwu, age=18, address=hubei}
 *     序列化： 就是把内存上的数据，转换为可以存储或者传输的数据。
 *     1,zhangsan,18,hubei
 *     2,lisi,18,hubei
 *     3,wangwu,18,hubei
 *     反序列化。 把字符串，变成Java里面的对象。
 *
 * @author Common-zhou
 * @since 2024-04-02 09:32
 */
public class Homework {

    public static void main(String[] args) {
        List<String> studentList = new ArrayList<>();

        boolean continueWorkFlag = true;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==================================");
            System.out.println("请输入你的选项： \n\t1.添加学生; \n\t2.删除学生; \n\t3.显示学生; \n\t4.退出系统 ");
            System.out.println("==================================");
            String inputChoice = scanner.nextLine();

            switch (inputChoice) {
                case "1":
                    addStudent(studentList, scanner);
                    break;
                case "2":
                    deleteStudent(studentList, scanner);
                    break;
                case "3":
                    // System.out.println("显示学生");
                    showStudent(studentList);
                    break;
                case "4":
                    continueWorkFlag = false;
                    // System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }

            if (!continueWorkFlag) {
                break;
            }

        }
    }

    private static void showStudent(List<String> studentList) {

        System.out.println("学生列表如下：");
        System.out.println(studentList);

        System.out.println("===================================");
    }

    private static void deleteStudent(List<String> studentList, Scanner scanner) {
        System.out.print("请输入要删除的用户姓名：");

        String inputName = scanner.nextLine();

        studentList.remove(inputName);

        System.out.println("删除" + inputName + "成功");

        System.out.println("===================================");

    }

    private static void addStudent(List<String> studentList, Scanner scanner) {
        // 添加学生。 应该。
        System.out.print("请输入用户的姓名：");

        String inputName = scanner.nextLine();

        studentList.add(inputName);

        System.out.println("添加" + inputName + "成功");

        System.out.println("===================================");

    }

}
