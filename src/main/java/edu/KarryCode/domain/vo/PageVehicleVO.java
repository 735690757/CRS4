package edu.KarryCode.domain.vo;

import edu.KarryCode.domain.po.Vehicle;
import lombok.*;

import java.util.List;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/22 下午 2:35
 * @PackageName edu.KarryCode.domain.vo
 * @ClassName PageVehicleVO
 * @Description TODO 当页车辆值对象
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageVehicleVO {
    /**
     * 总数
     */
    private Long totalCount;
    /**
     * 车辆列表
     */
    private List<Vehicle> vehicleList;
}
