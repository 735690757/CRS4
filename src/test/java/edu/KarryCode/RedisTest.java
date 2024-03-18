package edu.KarryCode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/25 下午 7:12
 * @PackageName edu.KarryCode
 * @ClassName redisTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
public class RedisTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void addKeyValueWithExpiration(String key, String value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, timeout, timeUnit);
    }
    @Test
    public void test(){
        addKeyValueWithExpiration("123@qq.com","HIJKBF",5,TimeUnit.MINUTES);
        String s = redisTemplate.opsForValue().get("123@qq.com");
        System.out.println(s);
    }
}
