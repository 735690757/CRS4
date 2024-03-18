package edu.KarryCode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.KarryCode.common.R;
import edu.KarryCode.domain.po.Vehicle;
import edu.KarryCode.mapper.VehicleMapper;
import edu.KarryCode.service.IVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/21 下午 9:23
 * @PackageName edu.KarryCode.service.impl
 * @ClassName VehicleServiceImpl
 * @Description TODO IVehicleService实现类
 * @Version 1.0
 */
@Slf4j
@Service
public class VehicleServiceImpl extends ServiceImpl<VehicleMapper, Vehicle> implements IVehicleService {

    @Override
    public R updateVehicle(Vehicle vehicle) {
        Vehicle vehicleID = baseMapper.selectById(vehicle.getId());
        if (vehicleID == null) {
            return R.error("车辆ID不存在！");
        }
        LambdaQueryWrapper<Vehicle> lambdaQueryWrapper = new LambdaQueryWrapper<Vehicle>()
                .eq(Vehicle::getVehicleLicense, vehicle.getVehicleLicense());
        Vehicle selectOneLicenseCheck = baseMapper.selectOne(lambdaQueryWrapper);
        if (selectOneLicenseCheck != null && !Objects.equals(selectOneLicenseCheck.getId(), vehicle.getId())){
            return R.error("车牌号已经存在！");
        }
        int i = baseMapper.updateById(vehicle);
        if (i == 0) {
            return R.error("数据库更新失败！");
        }
        return R.success(true);
    }

    @Override
    public R addVehicle(Vehicle vehicle) {
        String vehicleLicense = vehicle.getVehicleLicense();
        LambdaQueryWrapper<Vehicle> lambdaQueryWrapper = new LambdaQueryWrapper<Vehicle>()
                .eq(Vehicle::getVehicleLicense, vehicleLicense);
        Vehicle selectOne = baseMapper.selectOne(lambdaQueryWrapper);
        if (selectOne != null) {
            return R.error("车牌号已经存在！");
        }
        int insert = baseMapper.insert(vehicle);
        if (insert > 0) {
            return R.success(true);
        }
        return R.error("出错啦！");
    }

    @Override
    public R deleteVehicle(Integer id) {
        int i = baseMapper.deleteById(id);
        if (i > 0) {
            return R.success(true);
        }else {
            return R.error("车辆不存在！");
        }
    }

    @Override
    public List<Vehicle> getVehicleFuzzy(String fuzzy) {
        char isA;
        LambdaQueryWrapper<Vehicle> like;

        try {
            isA = fuzzy.charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            return null;
        }
        if (isA == 'A'){
            like = new LambdaQueryWrapper<Vehicle>().like(Vehicle::getVehicleLicense, fuzzy).last("limit 8");
            return baseMapper.selectList(like);
        }
        like = new LambdaQueryWrapper<Vehicle>().like(Vehicle::getVehicleName, fuzzy);
        return baseMapper.selectList(like);
    }
}
