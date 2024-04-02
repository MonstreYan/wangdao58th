package com.cskaoyan._20map._03example;

import org.junit.Test;

import java.util.*;

/**
 * Map是key-value。 要使用键值对来完成自己的业务需求。
 * 工作中的组合。
 * List<Student> list = new ArrayList<>();
 * Map<String,String> map  = new HashMap();
 * Set
 *
 * @author Common-zhou
 * @since 2024-04-02 17:11
 */
public class Demo4 {

    public static void main(String[] args) {
        List<Teacher> teachers = generateTeachers();
        List<Student1> student1s = generateStudents();

        // 最终，需要将老师和学生的数据组装到一起。

        List<Grade> grades = new ArrayList<>();

        // 时间复杂度是多少。
        //  老师是： m
        // 学生 n
        // m*n
        // 1000 * 100000 = 1亿
        // 5{
        //  50{}
        // }

        for (Teacher teacher : teachers) {
            List<Student1> student1s1 = new ArrayList<>();

            for (Student1 student1 : student1s) {
                if (student1.getTeacherId() == teacher.getId()) {
                    student1s1.add(student1);
                }
            }

            Grade grade = new Grade();
            grade.students = student1s1;
            grade.teacher = teacher;

            grades.add(grade);
        }


        for (Grade grade : grades) {

            System.out.println(grade);
        }


    }


    @Test
    public void test1() {
        List<Teacher> teachers = generateTeachers();
        List<Student1> student1s = generateStudents();

        // 一旦要使用使用Map。 就需要确定，什么是key，什么是value。

        // map1 : key是老师id， value是老师、
        // map2： key是老师id。 value是学生集合。
        Map<Integer, List<Student1>> map = new HashMap<>();

        // m   +  n
        for (Student1 student1 : student1s) {
            List<Student1> student1List = map.getOrDefault(student1.getTeacherId(), new ArrayList<>());

            student1List.add(student1);

            map.put(student1.getTeacherId(), student1List);
        }


        // map: key是teacherId； value是老师对应的学生。
        for (Teacher teacher : teachers) {
            int id = teacher.id;

            List<Student1> studentList = map.get(id);
        }
        // key是什么东西， value是什么东西
        // key和value 怎样组合来完成自己的需求。
    }

    @Test
    public void test3() {
        List<Teacher> teachers = generateTeachers();
        List<Student1> student1s = generateStudents();

        // map1：  key是老师id， value是老师、
        Map<Integer, Teacher> map = new HashMap<>();

        // map2:
        Map<Teacher, List<Student1>> map2 = new HashMap<>();

        for (Teacher teacher : teachers) {
            map.put(teacher.getId(), teacher);
        }

        for (Student1 student1 : student1s) {
            int teacherId = student1.getTeacherId();
            Teacher teacher = map.get(teacherId);
            List<Student1> studentList = map2.getOrDefault(teacher, new ArrayList<>());

            studentList.add(student1);
            // Map是个整体。
        }

        // map2

        // Map是个。 键值对的整体。
        // Entry

    }


    /**
     * 生成了5个老师。
     *
     * @return
     */
    private static List<Teacher> generateTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            Teacher teacher = new Teacher();
            teacher.id = i;
            teacher.name = "teacher_" + i;
            teacher.age = 35 + random.nextInt(5);

            teachers.add(teacher);
        }

        return teachers;
    }

    /**
     * 生成50个学生。
     *
     * @return
     */
    private static List<Student1> generateStudents() {
        List<Student1> students = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student1 student = new Student1();

            student.setId(i);
            student.setTeacherId(i % 5);
            student.setName("student" + i);
            student.setAge(15);

            students.add(student);
        }

        return students;
    }
}
