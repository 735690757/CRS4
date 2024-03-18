package edu.KarryCode.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/20 下午 6:30
 * @PackageName edu.KarryCode.config
 * @ClassName WebMvcConfig
 * @Description TODO SpringMVC Configuration 配置类文件
 * @Version 1.0
 */
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    // * @Author KarryLiu_刘珂瑞 * @Description TODO 资源处理器
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("静态资源映射开始");
        registry.addResourceHandler("/CRS/**").addResourceLocations("classpath:/app/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
