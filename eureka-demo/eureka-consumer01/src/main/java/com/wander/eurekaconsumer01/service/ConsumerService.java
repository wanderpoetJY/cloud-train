package com.wander.eurekaconsumer01.service;

import com.wander.eurekaconsumer01.pojo.Teacher;
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
