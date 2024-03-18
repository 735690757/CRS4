package edu.KarryCode.service;

import edu.KarryCode.domain.vo.DailyWordVO;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/23 上午 10:19
 * @PackageName edu.KarryCode.service
 * @ClassName IDailyWordService
 * @Description TODO 每日一言服务类接口
 * @Version 1.0
 */
public interface IDailyWordService {
    /**
     * @return 返回每日一言值对象
     */
    DailyWordVO getDailyWord();
}
