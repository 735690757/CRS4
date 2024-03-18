package edu.KarryCode.controller;

import edu.KarryCode.common.R;
import edu.KarryCode.domain.po.Orders;
import edu.KarryCode.domain.vo.StringIntVO;
import edu.KarryCode.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 10:32
 * @PackageName edu.KarryCode.controller
 * @ClassName OrdersController
 * @Description TODO 订单接口类
 * @Version 1.0
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;

    /**
     * @param request request
     * @return 最大订单
     * @Description 获取最大消费用户
     */
    @GetMapping("/maxFee")
    public R<Orders> getMaxFeeOrder(HttpServletRequest request) {
        Orders maxFeeOrder = iOrdersService.getMaxFeeOrder();
        if (maxFeeOrder == null) {
            return R.error("请求失败，内部错误");
        }
        return R.success(maxFeeOrder);
    }

    /**
     * @return 用户订单数据
     */
    @GetMapping("/getFeeOrders")
    public R<List<Orders>> getFeeOrd() {
        List<Orders> feeOrdersGroupByName = iOrdersService.getFeeOrdersGroupByName();
        if (feeOrdersGroupByName == null) return R.error("数据获取出错！");
        return R.success(feeOrdersGroupByName);
    }

    /**
     * @return 获取订单量
     */
    @GetMapping("/getFeeOrdersNum")
    public R<List<StringIntVO>> getFeeOrdNum() {
        List<StringIntVO> orderNumOrderByName = iOrdersService.getOrderNumOrderByName();
        if (orderNumOrderByName == null) return R.error("请求出错");
        return R.success(orderNumOrderByName);
    }

    /**
     * @return 最长时间还未归还的订单数据
     */
    @GetMapping("/longTimeNotReturned")
    public R<List<Orders>> longTimeNotReturned() {
        List<Orders> ordersHaveNotBeenReturned = iOrdersService.getOrdersHaveNotBeenReturned();
//        System.out.println(ordersHaveNotBeenReturned);
        return R.success(ordersHaveNotBeenReturned);
    }
}
