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
 * @Date 2023/11/28 下午 1:32
 * @PackageName edu.KarryCode.domain.po
 * @ClassName MessageLogTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
class MessageLogTest {
    @Autowired
    @Qualifier("CarRental3Mongodb")
    private MongoTemplate mongoTemplate;
    @Test
    public void test(){
        List<MessageLog> all = mongoTemplate.findAll(MessageLog.class);
        for (MessageLog messageLog : all) {
            System.out.println("messageLog = " + messageLog);
        }
    }

}