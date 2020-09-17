package cn.hd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class MyEurekaServerApplication {
    public static void main(String[] args) {
        log.info("服务注册中心启动成功:{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        SpringApplication.run(MyEurekaServerApplication.class, args);
    }
}
