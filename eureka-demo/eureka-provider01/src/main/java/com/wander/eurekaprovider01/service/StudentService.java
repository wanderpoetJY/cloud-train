package com.wander.eurekaprovider01.service;

import java.util.List;

import com.wander.eurekaprovider01.pojo.Student;
import org.springframework.stereotype.Service;

/**
 * 学生服务
 *
 * @author admin 2020/12/30/ 11:12
 */
@Service
public interface StudentService {

    List<Student> getAllStudent();
}
