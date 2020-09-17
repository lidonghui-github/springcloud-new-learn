package cn.hd;

import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class MyCustomerApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        log.info("用户服务模块MyCustomer启动:{}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        SpringApplication.run(MyCustomerApplication.class);

    }
}
