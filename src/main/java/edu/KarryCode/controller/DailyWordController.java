package edu.KarryCode.controller;

import edu.KarryCode.common.R;
import edu.KarryCode.domain.vo.DailyWordVO;
import edu.KarryCode.service.IDailyWordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/23 上午 10:44
 * @PackageName edu.KarryCode.controller
 * @ClassName DailyWordController
 * @Description TODO 每日一句接口类
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/daily")
public class DailyWordController {
    @Autowired
    private IDailyWordService iDailyWordService;

    /**
     * @return R 每日一言值对象
     */
    @GetMapping
    public R<DailyWordVO> getDailyWord() {
        DailyWordVO dailyWord = iDailyWordService.getDailyWord();
        return R.success(dailyWord);
    }
}
