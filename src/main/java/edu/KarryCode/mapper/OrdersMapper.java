package edu.KarryCode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.KarryCode.domain.po.Orders;
import edu.KarryCode.domain.vo.CustomerVehicleVO;
import edu.KarryCode.domain.vo.StringIntVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 8:34
 * @PackageName edu.KarryCode.mapper
 * @ClassName OrdersMapper
 * @Description TODO 订单表Mapper，这里只负责复杂查询，简单查询由MybatisPlus接管
 * @Version 1.0
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    /**
     * @return 单笔最大订单
     */
    Orders getMaxFeeOrders();

    /**
     * @return 根据用户名分组查询订单
     */
    List<Orders> getFeeOrdersGroupByName();

    /**
     * @return 根据名字分组查询订单
     */
    List<StringIntVO> getOrderNumGroupName();

    List<CustomerVehicleVO> selectCustomerVehicle();
}
