package com.wander.eurekaprovider01.service.impl;

import java.util.Arrays;
import java.util.List;

import com.wander.eurekaprovider01.pojo.Student;
import com.wander.eurekaprovider01.service.StudentService;
import org.springframework.stereotype.Component;

/**
 * shixianlei
 *
 * @author admin 2020/12/30/ 11:13
 */
@Component
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getAllStudent() {
        return Arrays.asList(
                new Student("小明",18),
                new Student("小红",18),
                new Student("李华",18)
        );
    }
}
