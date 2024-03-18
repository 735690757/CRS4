package edu.KarryCode.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.KarryCode.domain.po.DailyWord;
import edu.KarryCode.domain.vo.DailyWordVO;
import edu.KarryCode.service.IDailyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/23 上午 10:19
 * @PackageName edu.KarryCode.service.impl
 * @ClassName DailyWordVOServiceImpl
 * @Description TODO IDailyWordService实现类
 * @Version 1.0
 */
@Service
public class DailyWordVOServiceImpl implements IDailyWordService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public DailyWordVO getDailyWord() {
        try {
            URL url = new URL("https://www.zxperson.com/api/doc/yiyan");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            conn.disconnect();
            ObjectMapper objectMapper = new ObjectMapper();
            DailyWordVO dailyWordVO = objectMapper.readValue(response.toString(), DailyWordVO.class);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            DailyWord dailyWordMongo = DailyWord.builder()
                    .content(dailyWordVO.getData())
                    .createDate(simpleDateFormat.format(date))
                    .build();


            Query query1 = new Query();
            long count = mongoTemplate.count(query1, DailyWord.class);
            if (count>100){
                Query query = new Query().with(Sort.by(Sort.Order.asc("createDate")));
                mongoTemplate.remove(query.limit(1), DailyWord.class);
            }
            mongoTemplate.insert(dailyWordMongo);
            System.out.println("有网咯！");
            return dailyWordVO;
        } catch (IOException e) {
            Aggregation aggregation = Aggregation.newAggregation(
                    Aggregation.sample(1)
            );
            DailyWord randomDocument = mongoTemplate.aggregate(aggregation, "dailyWord", DailyWord.class)
                    .getUniqueMappedResult();
            if (randomDocument != null) {
                System.out.println("没网咯，使用MongoDB！");
                return DailyWordVO.builder()
                        .data(randomDocument.getContent()).code(1).build();
            }
            System.out.println("这回彻底废了！");
            return DailyWordVO.builder().data("鸭，失联了~~").build();
        }

    }
}
