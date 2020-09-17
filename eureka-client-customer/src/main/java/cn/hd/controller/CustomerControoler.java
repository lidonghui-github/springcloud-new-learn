package cn.hd.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerControoler {
    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private EurekaClient eurekaClient;  // 用于获取服务信息


    @GetMapping("/index")
    public String customer() {
        //1.通过 EurekaClient 获取 MySearch 服务的信息
        InstanceInfo info = eurekaClient.getNextServerFromEureka("MYSEARCH", false);

        //2.获取到访问的地址
        String url = info.getHomePageUrl();
        log.info("获取到的服务的名称是:{}", info.getAppName());
        log.info("获取到的服务的访问地址是:{}", url);
        //3.通过 RestTemplate 进行访问
        String result = restTemplate.getForObject(url + "/search/index", String.class);
        //4.返回结果
        return result;
    }
}
