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

@RestController
public class MainController {
    @Autowired
    DiscoveryClient client;

    @Autowired
    EurekaClient ekclient;

    @GetMapping("/getHi")
    public String getHi(){
        return "Hi";
    }

    @GetMapping("/client")
    public String client(){
        List<String> services = client.getServices();
        for (String service :
                services) {
            System.out.println(service);
        }
        System.out.println(ToStringBuilder.reflectionToString(services));
        return "Hi";
    }

    @GetMapping("/client2")
    public Object client2(){
        return client.getInstances("provider");
    }

    @GetMapping("/client3")
    public Object client3(){
        List<ServiceInstance> instances = client.getInstances("provider");
        instances.forEach(System.out::println);
        return instances;
    }

    @GetMapping("/client4")
    public Object client4(){
        //List<InstanceInfo> instances = ekclient.getInstancesById("DESKTOP-259989E:provider:80");
        List<InstanceInfo> instances = ekclient.getInstancesByVipAddress("provider", false);
        instances.forEach(System.out::println);
        if(instances.size()>0){
            InstanceInfo instanceInfo = instances.get(0);
            if(instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP){
                String url = "http://" + instanceInfo.getHostName() +":"+ instanceInfo.getPort()+"/getHi";
                System.out.println("url:" + url);
                RestTemplate restTemplate = new RestTemplate();
                String respStr = restTemplate.getForObject(url, String.class);
                System.out.println("respStr:" + respStr);
            }
        }
        return "xxoo";
    }

    @Autowired
    LoadBalancerClient lb;

    //LoadBalancer
    @GetMapping("/client5")
    public Object client5(){
        ServiceInstance instance = lb.choose("provider");//ribbon负载均衡策略
        String url = "http://" + instance.getHost() +":"+ instance.getPort()+"/getHi";
        System.out.println("url:" + url);
        RestTemplate restTemplate = new RestTemplate();
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:" + respStr);
        return "xxoo";
    }
}
