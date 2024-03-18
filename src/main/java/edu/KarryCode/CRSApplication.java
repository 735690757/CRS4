package edu.KarryCode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/20 下午 6:27
 * @PackageName edu.KarryCode
 * @ClassName CRSApplication
 * @Description TODO 核心启动类
 * @Version 1.0
 */
@Slf4j
@SpringBootApplication
public class CRSApplication {
    public static void main(String[] args) {
        SpringApplication.run(CRSApplication.class,args);
        log.info("启动成功，欢迎使用CRS4");
    }
}
