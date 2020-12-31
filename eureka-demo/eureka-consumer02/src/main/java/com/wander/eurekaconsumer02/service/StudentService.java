package com.wander.eurekaconsumer02.service;

import java.util.List;

import com.wander.eurekaconsumer02.pojo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * openfeign远程调用
 *
 * @author admin 2020/12/31/ 10:19
 */
@FeignClient("eureka-provider")
public interface StudentService {


    @GetMapping("/student/")
    List<Student> selectStudentByOpenFeign();
}
