package com.wander.eurekaconsumer01.service.impl;

import java.util.List;
import com.wander.eurekaconsumer01.pojo.Student;
import com.wander.eurekaconsumer01.pojo.Teacher;
import com.wander.eurekaconsumer01.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

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
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Override
    public Teacher getTeacherById(int id) {
        return new Teacher("哈哈哈", 18, selectByLoadBalancerClient());
    }

    private List<Student> selectByDiscoveryClient() {
        StringBuffer sb = null;

        //获取所有服务列表
//        List<String> services = discoveryClient.getServices();
//        if (CollectionUtils.isEmpty(services)) {
//            return null;
//        }

        //根据服务名获取指定服务列表
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("eureka-provider");
        if (CollectionUtils.isEmpty(serviceInstances)) {
            return null;
        }

        //指定使用服务中的哪一个
        ServiceInstance serviceInstance = serviceInstances.get(0);

        //封装请求url
        sb = new StringBuffer();
        sb.append("http://")
          .append(serviceInstance.getHost())
          .append(":")
          .append(serviceInstance.getPort())
          .append("/student");

        //通过url请求数据并封装数据返回
        ResponseEntity<List<Student>> response = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>(){});

        return response.getBody();
    }


    private List<Student> selectByLoadBalancerClient() {
        StringBuffer sb = null;

        //获取服务列表


        //根据服务名获取服务
       ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider");
        if (serviceInstance == null) {
            return null;
        }

        //封装请求url
        sb = new StringBuffer();
        sb.append("http://")
          .append(serviceInstance.getHost())
          .append(":")
          .append(serviceInstance.getPort())
          .append("/student");

        //通过url请求数据并封装数据返回
        ResponseEntity<List<Student>> response = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>(){});
        System.out.println(sb);
        return response.getBody();
    }

    private List<Student> selectByLoadBalanced() {

        //通过url请求数据并封装数据返回
        ResponseEntity<List<Student>> response = restTemplate.exchange(
                "http://eureka-provider/student",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>(){});

        return response.getBody();
    }


}
