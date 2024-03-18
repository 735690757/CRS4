package edu.KarryCode.repositoryRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/25 下午 7:25
 * @PackageName edu.KarryCode.repositoryRedis
 * @ClassName CommonTools
 * @Description TODO Redis模板类
 * @Version 1.0
 */
@Component
public class CommonToolsRedis {
    @Autowired
    public RedisTemplate<String, String> redisTemplate;

    /**
     * @param key      键
     * @param value    值
     * @param timeout  失效时间
     * @param timeUnit 时间单位
     * @Description 通用模板，比如向Redis存一个邮箱与验证码关联数据并设置失效时间
     */
    public void addKeyValueWithExpiration(String key, String value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, timeout, timeUnit);
    }
}
