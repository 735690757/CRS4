package edu.KarryCode.domain.po;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/9/24 下午 4:01
 * @PackageName edu.KarryCode.entity
 * @ClassName RankEntity
 * @Description TODO 排行榜单条实体
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document("RankEntity")
public class RankEntity {
    /**
     * 车辆名
     */
    private String name;
    /**
     * 车辆分数
     */
    private Double score;
}
