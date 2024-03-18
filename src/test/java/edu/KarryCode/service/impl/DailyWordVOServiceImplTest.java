package edu.KarryCode.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.KarryCode.domain.vo.DailyWordVO;
import edu.KarryCode.service.IDailyWordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/23 上午 10:23
 * @PackageName edu.KarryCode.service.impl
 * @ClassName DailyWordVOServiceImplTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
class DailyWordVOServiceImplTest {
    @Autowired
    private IDailyWordService iDailyWordService;
    @Test
    public void test() throws JsonProcessingException {
        DailyWordVO dailyWord = iDailyWordService.getDailyWord();
        System.out.println("dailyWord = " + dailyWord);
    }

}