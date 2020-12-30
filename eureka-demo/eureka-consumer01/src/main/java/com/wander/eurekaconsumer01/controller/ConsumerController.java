package com.wander.eurekaconsumer01.controller;

import java.util.List;

import com.wander.eurekaconsumer01.pojo.Teacher;
import com.wander.eurekaconsumer01.service.impl.ConsumerServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者
 *
 * @author admin 2020/12/30/ 14:12
 */
@RestController
@RequestMapping("/teacher")
public class ConsumerController {

    @Autowired
    ConsumerServiceImpl consumerService;

    @GetMapping("/{id}")
   public Teacher getTeacherById(@PathVariable("id") int id){
       return  consumerService.getTeacherById(id);
   }
}
