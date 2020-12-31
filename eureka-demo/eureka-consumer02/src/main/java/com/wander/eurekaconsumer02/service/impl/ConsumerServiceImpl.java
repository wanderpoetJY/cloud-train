package com.wander.eurekaconsumer02.service.impl;

import com.wander.eurekaconsumer02.pojo.Teacher;
import com.wander.eurekaconsumer02.service.ConsumerService;
import com.wander.eurekaconsumer02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;


/**
 * 分别使用DiscoveryClient，LoadBalancerClient，LoadBalanced实现远程方法调用
 * DiscoveryClient:获取到的是服务列表，需要自己通过索引指定使用哪个服务
 * LoadBalancerClient：会自己判断使用哪个服务，不需要自己指定
 * LoadBalanced：LoadBalancerClient注解版,在配置RestTemplate bean上加注解即可。
 * 不再需要自己获取服务，只需要在url中指定服务名即可
 *
 *
 * @author admin 2020/12/30/ 14:21
 */
@Component
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    StudentService studentService;


    @Override
    public Teacher getTeacherById(int id) {
        return new Teacher("哈哈哈", 18,studentService.selectStudentByOpenFeign());
    }




}
