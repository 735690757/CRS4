package edu.KarryCode.domain.po;

import lombok.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 8:30
 * @PackageName edu.KarryCode.domain.po
 * @ClassName Orders
 * @Description TODO 订单实体类
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Orders {
    private Integer id;
    /**
     * 订单用户名字
     */
    private String name;
    /**
     * 订单车牌号
     */
    private String license;
    /**
     * 订单出借日期
     */
    private String borrowdate;
    /**
     * 订单返回日期
     */
    private String returndate;
    /**
     * 订单费用
     */
    private Double fee;
    /**
     * 订单归还状态
     */
    private Boolean restate;
}
