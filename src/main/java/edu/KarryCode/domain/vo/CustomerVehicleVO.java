package edu.KarryCode.domain.vo;

import lombok.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/12 下午 9:38
 * @PackageName edu.KarryCode.entity
 * @ClassName CustomerVehicle
 * @Description TODO 顾客车辆值对象
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class CustomerVehicleVO {
    /**
     * 顾客名
     */
    private String customerName;
    /**
     * 车辆名
     */
    private String vehicleName;
}
