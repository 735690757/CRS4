package edu.KarryCode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.KarryCode.domain.po.Vehicle;
import edu.KarryCode.mapper.VehicleMapper;
import edu.KarryCode.service.IVehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/21 下午 9:27
 * @PackageName edu.KarryCode.service.impl
 * @ClassName VehicleServiceImplTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
class VehicleServiceImplTest {
    @Autowired
    private IVehicleService iVehicleService;
    @Autowired
    private VehicleMapper vehicleMapper;
    @Test
    public void testV(){
//        List<Vehicle> list = iVehicleService.list();
        Page<Vehicle> vehiclePage = new Page<>();
        vehiclePage.setCurrent(1L);
        vehiclePage.setSize(5L);

        Page<Vehicle> page = iVehicleService.page(vehiclePage);
        List<Vehicle> records = page.getRecords();
        System.out.println(page.getTotal());
        for (Vehicle vehicle : records) {
            System.out.println(vehicle);
        }
//        LambdaQueryWrapper<Vehicle> vehicleLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        Page<Vehicle> vehiclePage1 = vehicleMapper.selectPage(vehiclePage, vehicleLambdaQueryWrapper);
//        List<Vehicle> records = vehiclePage1.getRecords();
//        for (Vehicle record : records) {
//            System.out.println(record);
//        }
    }
    @Test
    public void testFuzzy(){
        List<Vehicle> a80 = iVehicleService.getVehicleFuzzy("A901");
        for (Vehicle vehicle : a80) {
            System.out.println(vehicle);
        }
    }
}