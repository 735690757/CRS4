package edu.KarryCode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author KarryLiu
 * @Creed may all the beauty be blessed
 * @Date 2024/2/28 上午 11:16
 * @PackageName edu.KarryCode.config
 * @ClassName SpringBootDiverseMounts
 * @Description TODO
 * @Version 1.0
 */
@Configuration
public class SpringBootDiverseMounts {
    @PostConstruct
    public void init() throws InterruptedException {
        System.out.println("============= 欢迎使用CRS4 ==============");
        System.out.println("   ____  ____   ____   _  _  __ __ __  ");
        System.out.println("  / ___||  _ \\ / ___| | || | \\ \\\\ \\\\ \\ ");
        System.out.println(" | |    | |_) |\\___ \\ | || |_ \\ \\\\ \\\\ \\");
        System.out.println(" | |___ |  _ <  ___) ||__   _|/ // // /");
        System.out.println("  \\____||_| \\_\\|____/    |_| /_//_//_/ ");
        System.out.println("======= 刘珂瑞·诗岸梦行舟·Karry.Liu ========");
        Thread.sleep(1500);
    }
}
