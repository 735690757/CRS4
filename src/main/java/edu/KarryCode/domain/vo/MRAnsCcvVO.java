package edu.KarryCode.domain.vo;

import lombok.*;

/**
 * @Author KarryLiu
 * @Creed may all the beauty be blessed
 * @Date 2023/11/28 下午 8:52
 * @PackageName edu.KarryCode.domain.vo
 * @ClassName MRAnsCcvVO
 * @Description TODO MapReduce联想结果值对象
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class MRAnsCcvVO {
    /**
     * 顾客A
     */
    private String CustomerA;
    /**
     * 顾客B
     */
    private String CustomerB;
    /**
     * A与B的共同爱好车辆
     */
    private String Vehicle;
}
