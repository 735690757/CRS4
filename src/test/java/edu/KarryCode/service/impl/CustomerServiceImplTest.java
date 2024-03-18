package edu.KarryCode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.KarryCode.domain.po.Customer;
import edu.KarryCode.service.ICustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 8:26
 * @PackageName edu.KarryCode.service.impl
 * @ClassName CustomerServiceImplTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private ICustomerService iCustomerService;
    @Test
    public void test(){
        BaseMapper<Customer> baseMapper = iCustomerService.getBaseMapper();
        LambdaQueryWrapper<Customer> customerLambdaQueryWrapper = new LambdaQueryWrapper<Customer>().orderByDesc(Customer::getMoney);
        List<Customer> customers = baseMapper.selectList(customerLambdaQueryWrapper);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}