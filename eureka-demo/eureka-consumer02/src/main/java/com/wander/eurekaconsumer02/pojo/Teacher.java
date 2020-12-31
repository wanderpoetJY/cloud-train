package com.wander.eurekaconsumer02.pojo;

import java.util.List;

/**
 * 老师实体类
 *
 * @author admin 2020/12/30/ 14:08
 */
public class Teacher {

    private String name;
    private int age;
    private List<Student> students;

    public Teacher() {
    }

    public Teacher(String name, int age, List<Student> students) {
        this.name = name;
        this.age = age;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", students=" + students +
                '}';
    }
}
