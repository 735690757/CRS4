package edu.KarryCode.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.math.BigDecimal;


/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/21 下午 9:16
 * @PackageName edu.KarryCode.domain.po
 * @ClassName Vehicle
 * @Description TODO 车辆实体类
 * @Version 1.0
 */
@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    /**
     * 车辆id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 车辆车牌后
     */
    private String vehicleLicense;
    /**
     * 车辆名
     */
    private String vehicleName;
    /**
     * 车辆租赁日期
     */
    private BigDecimal vehicleRent;
    /**
     * 车辆状态
     */
    private Boolean vehicleState;

}
