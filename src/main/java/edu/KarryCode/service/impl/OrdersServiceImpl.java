package edu.KarryCode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.KarryCode.domain.po.Orders;
import edu.KarryCode.domain.vo.MRAnsCcvVO;
import edu.KarryCode.domain.vo.StringIntVO;
import edu.KarryCode.mapper.OrdersMapper;
import edu.KarryCode.service.IOrdersService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 8:41
 * @PackageName edu.KarryCode.service.impl
 * @ClassName OrdersServiceImpl
 * @Description TODO IOrdersService实现类
 * @Version 1.0
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {
    @Override
    public Orders getMaxFeeOrder() {
        Orders maxFeeOrders = baseMapper.getMaxFeeOrders();
        if (maxFeeOrders == null){
            return null;
        }
        return maxFeeOrders;
    }

    @Override
    public List<Orders> getFeeOrdersGroupByName() {
        return baseMapper.getFeeOrdersGroupByName();
    }

    @Override
    public List<StringIntVO> getOrderNumOrderByName() {
        return baseMapper.getOrderNumGroupName();
    }

    @Override
    public List<Orders> getOrdersHaveNotBeenReturned() {
        LambdaQueryWrapper<Orders> ordersLambdaQueryWrapper =
                new LambdaQueryWrapper<Orders>()
                .eq(Orders::getRestate, false)
                        .orderByDesc()
                        .last("limit 3");;

        List<Orders> orders = baseMapper.selectList(ordersLambdaQueryWrapper);
        return orders;
    }

    @Override
    public List<MRAnsCcvVO> getCommonPreferences() {
        String filePath = "CV_Like_S2_output\\part-r-00000";
        List<MRAnsCcvVO> mrAnsCcvVOS = new ArrayList<MRAnsCcvVO>();

        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            for (String line : lines) {
                String[] split = line.split("\t");
                String[] twoCus = split[0].split("-");
                String cusA = twoCus[0];
                String cusB = twoCus[1];
                String vec = split[1].substring(0,split[1].length() - 1);
                MRAnsCcvVO mrAnsCcvVO = MRAnsCcvVO.builder().CustomerA(cusA).CustomerB(cusB).Vehicle(vec).build();
                mrAnsCcvVOS.add(mrAnsCcvVO);
            }
            return mrAnsCcvVOS;
        } catch (IOException e) {
            System.out.println("文件读异常");
            return null;
        }
    }
}
