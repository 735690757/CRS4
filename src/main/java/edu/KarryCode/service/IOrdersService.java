package edu.KarryCode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.KarryCode.domain.po.Orders;
import edu.KarryCode.domain.vo.MRAnsCcvVO;
import edu.KarryCode.domain.vo.StringIntVO;

import java.util.List;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 8:40
 * @PackageName edu.KarryCode.service
 * @ClassName IOrdersService
 * @Description TODO 订单接口类
 * @Version 1.0
 */
public interface IOrdersService extends IService<Orders> {
    /**
     * @return 对打订单数据
     */
    Orders getMaxFeeOrder();

    /**
     * @return 通过名字分组获取订单列表
     */
    List<Orders> getFeeOrdersGroupByName();

    /**
     * @return 根据名字扽组获取订单数量，并以列表形式返回
     */

    List<StringIntVO> getOrderNumOrderByName();

    /**
     * @return 获取未归还车辆的用户信息
     */

    List<Orders> getOrdersHaveNotBeenReturned();

    /**
     * @return 共讨喜好的列表
     */
    List<MRAnsCcvVO> getCommonPreferences();
}
