package edu.KarryCode.domain.vo;

import lombok.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/29 下午 4:17
 * @PackageName edu.KarryCode.domain.vo
 * @ClassName StringIntVO
 * @Description TODO 字符串-整形值对象
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StringIntVO {
    /**
     * 一个字符串
     */
    private String name;
    /**
     * 一个整形
     */
    private Integer value;
}
