package edu.KarryCode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.KarryCode.common.R;
import edu.KarryCode.domain.po.Vehicle;

import java.util.List;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/21 下午 9:23
 * @PackageName edu.KarryCode.service
 * @ClassName IVehicleService
 * @Description TODO 车辆服务类接口
 * @Version 1.0
 */
public interface IVehicleService extends IService<Vehicle> {
    /**
     * @Description 更新车辆
     */
    R updateVehicle(Vehicle vehicle);

    /**
     * @Description 添加车辆
     */

    R addVehicle(Vehicle vehicle);

    /**
     * @Description 删除车辆
     */

    R deleteVehicle(Integer id);

    /**
     * @Description 自适应模糊查询
     */
    List<Vehicle> getVehicleFuzzy(String fuzzy);

}
