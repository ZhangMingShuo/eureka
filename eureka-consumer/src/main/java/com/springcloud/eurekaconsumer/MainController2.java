package com.springcloud.eurekaconsumer;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
public class MainController2 {
    @Autowired
    DiscoveryClient client;

    @Autowired
    EurekaClient ekclient;

    @Autowired
    LoadBalancerClient lb;

    //LoadBalancer
    @GetMapping("/client6")
    public Object client6(){
        ServiceInstance instance = lb.choose("provider");//ribbon负载均衡策略
        String url = "http://" + instance.getHost() +":"+ instance.getPort()+"/getHi";
        System.out.println("url:" + url);
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:" + respStr);
        return respStr;
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/client7")
    public Object client7(){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider");
        instanceList.forEach(System.out::println);
        //自定义轮询算法
        int nextInt = new Random().nextInt(instanceList.size());
        ServiceInstance instance = instanceList.get(nextInt);
        
        System.out.println("instances "+instanceList);
        //ServiceInstance instance = lb.choose("provider");//ribbon负载均衡策略
        String url = "http://" + instance.getHost() +":"+ instance.getPort()+"/getHi";
        System.out.println("url:" + url);
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:" + respStr);
        return respStr;
    }

    @GetMapping("/client8")
    public Object client8(){
        ServiceInstance instance = lb.choose("provider");//ribbon负载均衡策略
        String url = "http://" + instance.getHost() +":"+ instance.getPort()+"/getHi";
        System.out.println("url:" + url);
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:" + respStr);
        return respStr;
    }

    /**
     * 自动处理url
     * @return 请求结果
     */
    @GetMapping("/client9")
    public Object client9(){
        String url = "http://provider/getHi";
        System.out.println("url:" + url);
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:" + respStr);
        return respStr;
    }
}
