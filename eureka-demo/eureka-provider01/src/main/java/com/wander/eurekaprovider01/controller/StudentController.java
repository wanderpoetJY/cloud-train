package com.wander.eurekaprovider01.controller;

import java.util.List;

import com.wander.eurekaprovider01.pojo.Student;
import com.wander.eurekaprovider01.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生Controller
 *
 * @author admin 2020/12/30/ 11:10
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping
    public List<Student> getAllStudent(){
       return studentService.getAllStudent();
    }
}
