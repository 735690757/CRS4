package edu.KarryCode.domain.vo;

import lombok.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/23 上午 10:16
 * @PackageName edu.KarryCode.domain.vo
 * @ClassName DailyWord
 * @Description TODO 每日一言值对象
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DailyWordVO {
    /**
     * 请求码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 每日一言值对象数据
     */
    private String data;
}
