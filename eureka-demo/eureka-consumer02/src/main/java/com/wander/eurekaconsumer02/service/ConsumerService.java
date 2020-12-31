package com.wander.eurekaconsumer02.service;

import com.wander.eurekaconsumer02.pojo.Teacher;
import org.springframework.stereotype.Service;

/**
 * 消费者服务
 *
 * @author admin 2020/12/30/ 14:07
 */
@Service
public interface ConsumerService {


    Teacher getTeacherById(int id);
}
