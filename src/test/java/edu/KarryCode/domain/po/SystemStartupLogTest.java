package edu.KarryCode.domain.po;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author KarryLiu
 * @Creed may all the beauty be blessed
 * @Date 2023/11/28 上午 10:05
 * @PackageName edu.KarryCode.domain.po
 * @ClassName SystemStartupLogTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
class SystemStartupLogTest {
    @Autowired
    @Qualifier("CarRental3Mongodb")
    private MongoTemplate mongoTemplate;
    @Test
    public void test(){
//        mongoTemplate
        List<SystemStartupLog> all = mongoTemplate.findAll(SystemStartupLog.class);
        for (SystemStartupLog systemStartupLog : all) {

            System.out.println("systemStartupLog = " + systemStartupLog);
        }
    }
}