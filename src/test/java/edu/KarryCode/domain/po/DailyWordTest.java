package edu.KarryCode.domain.po;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/23 下午 2:18
 * @PackageName edu.KarryCode.domain.po
 * @ClassName DailyWordTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
class DailyWordTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public void test() throws InterruptedException {
//        Query query = new Query();
//        long count = mongoTemplate.count(query, DailyWord.class);
//        System.out.println("count = " + count);


        for (;;) {
            Aggregation aggregation = Aggregation.newAggregation(
                    Aggregation.sample(1)
            );
            DailyWord randomDocument = mongoTemplate.aggregate(aggregation, "dailyWord", DailyWord.class)
                    .getUniqueMappedResult();
            System.out.println("randomDocument = " + randomDocument);
            Thread.sleep(1000);
        }
    }
    @Test
    public void testRemove(){
        Query query1 = new Query();
        long count = mongoTemplate.count(query1, DailyWord.class);
        System.out.println("count = " + count);

        Query query = new Query().with(Sort.by(Sort.Order.asc("createDate")));
        mongoTemplate.remove(query.limit(1), DailyWord.class);
    }
}