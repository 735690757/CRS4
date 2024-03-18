package edu.KarryCode.domain.po;

import lombok.*;

import java.util.Date;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/23 下午 2:11
 * @PackageName edu.KarryCode.domain.po
 * @ClassName DailyWord
 * @Description TODO 每日一言实体类
 * @Version 1.0
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DailyWord {
    /**
     * 一言内容
     */
    private String content;
    /**
     * 创建日期
     */
    private String createDate;
}
