package edu.KarryCode.config;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

/**
 * @Author KarryLiu
 * @Creed may all the beauty be blessed
 * @Date 2023/11/28 上午 10:44
 * @PackageName edu.KarryCode.config
 * @ClassName MongoDBConfig
 * @Description TODO MongoDB多数据源配置，通过不同的名称配合Qualifier切换数据源
 * @Version 1.0
 */
@Configuration
public class MongoDBConfig {

    @Value("${spring.data.mongodb.url}")
    private String mongoUrl;

    @Value("${spring.data.mongodb.database.CRS4}")
    private String CRS4;

    @Value("${spring.data.mongodb.database.CarRental3Mongodb}")
    private String CarRental3Mongodb;

    @Primary
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(
                new SimpleMongoClientDatabaseFactory(MongoClients.create(mongoUrl), CRS4));
    }

    @Bean(name = "CRS4")//数据源1的database使用CRS4
    public  MongoTemplate mongoTemplateTest() {
        return new MongoTemplate(
                new SimpleMongoClientDatabaseFactory(MongoClients.create(mongoUrl), CRS4));
    }

    @Bean(name = "CarRental3Mongodb")//数据源2的database使用CarRental3Mongodb
    public MongoTemplate mongoTemplateTest1() {
        return new MongoTemplate(
                new SimpleMongoClientDatabaseFactory(MongoClients.create(mongoUrl), CarRental3Mongodb));
    }
    // 开启事务
    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory factory){
        return new MongoTransactionManager(factory);
    }
}
