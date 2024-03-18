package edu.KarryCode.service.impl;

import edu.KarryCode.domain.po.Orders;
import edu.KarryCode.domain.vo.StringIntVO;
import edu.KarryCode.service.IOrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 8:43
 * @PackageName edu.KarryCode.service.impl
 * @ClassName OrdersServiceImplTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
class OrdersServiceImplTest {
    @Autowired
    private IOrdersService iordersService;
    @Test
    public void test(){
        List<Orders> list = iordersService.list();
        for (Orders orders : list) {
            System.out.println(orders);
        }
    }
    @Test
    public void testX(){
        List<StringIntVO> orderNumOrderByName = iordersService.getOrderNumOrderByName();
        System.out.println(orderNumOrderByName);
    }
    @Test
    public void test3(){
        iordersService.getCommonPreferences();
    }
}