package com.cskaoyan._20map._03example;

import org.junit.Test;

import java.util.*;

/**
 * 使用Map。尤其要注意，key是什么东西，value 是什么东西。
 * 一定让key和value组合起来，能更好的完成业务需求。
 *
 * @author Common-zhou
 * @since 2024-04-02 16:06
 */
public class Demo1 {
    @Test
    public void test1() {
        // 班级里有一些学生，我想根据省份进行分组，应该怎么做？

        // 分组： 将省份相同的同学，放到一个组里。 （List）
        // 比如，有50个同学， 有一些同学来自湖北，有些同学来自内蒙。

    }

    @Test
    public void test2() {
        List<Student> studentList = generateStudents();

        // System.out.println(studentList);

        // 最终的目的。 分组。 相同省份的，放在一个List 里面

        // 用什么完成。 Map。
        // 一定要确定，key是什么，value 是什么。
        // key和value如何帮助我完成业务需求。

        // key是省份，value是 List<Student>.
        // value 是这个省份的所有学生。
        Map<String, List<Student>> provinceRelatedStudentListMap = new HashMap<>();

        // 遍历学生
        for (Student student : studentList) {
            // 现在假设，zs 进来了，要来找同省的兄弟姐妹们。

            List<Student> sameProvinceStudentList = provinceRelatedStudentListMap.get(student.getProvince());

            if (sameProvinceStudentList == null) {
                sameProvinceStudentList = new ArrayList<>();
            }
            sameProvinceStudentList.add(student);

            provinceRelatedStudentListMap.put(student.getProvince(), sameProvinceStudentList);
        }
        // Map是没有foreach的。 只能用 entrySet 、keySet

        Set<Map.Entry<String, List<Student>>> entries = provinceRelatedStudentListMap.entrySet();
        for (Map.Entry<String, List<Student>> entry : entries) {

            String key = entry.getKey();
            List<Student> value = entry.getValue();

            System.out.println(key + "======" + value);

            System.out.println("========================================");

        }


    }


    private static List<Student> generateStudents() {
        List<Student> students = new ArrayList<>();

        List<String> provinceList = Arrays.asList("hubei", "hunan", "guangdong");

        for (int i = 0; i < 50; i++) {
            Student student = new Student();
            student.setName("student" + i);
            student.setAge(15);
            // 从省份的list中，获取出一个省份，设置到学生上

            // 0 1  2 3 4 5  6
            // 3
            String province = provinceList.get(i % provinceList.size());
            student.setProvince(province);

            students.add(student);
        }

        return students;
    }


}

class Student {
    String name;
    int age;
    String province;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public Student setProvince(String province) {
        this.province = province;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", province='" + province + '\'' + '}';
    }
}
