package edu.KarryCode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.KarryCode.domain.po.Vehicle;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/21 下午 9:22
 * @PackageName edu.KarryCode.mapper
 * @ClassName VehicleMapper
 * @Description TODO 车辆表Mapper，这里只负责复杂查询，简单查询由MybatisPlus接管
 * @Version 1.0
 */
@Mapper
public interface VehicleMapper extends BaseMapper<Vehicle> {
}
