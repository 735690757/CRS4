package edu.KarryCode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.KarryCode.common.R;
import edu.KarryCode.domain.po.Customer;
import edu.KarryCode.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 9:25
 * @PackageName edu.KarryCode.controller
 * @ClassName CustomerController
 * @Description TODO 顾客数据接口类
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    /**
     * @return 返回顾客列表
     */
    @GetMapping("/getCustomerList")
    public R<List<Customer>> getCustomerList() {
        BaseMapper<Customer> baseMapper = iCustomerService.getBaseMapper();
        LambdaQueryWrapper<Customer> customerLambdaQueryWrapper = new LambdaQueryWrapper<Customer>().orderByDesc(Customer::getMoney);
        List<Customer> customers = baseMapper.selectList(customerLambdaQueryWrapper);
        return R.success(customers);
    }
}
