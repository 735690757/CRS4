package edu.KarryCode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.KarryCode.domain.po.Customer;
import edu.KarryCode.mapper.CustomerMapper;
import edu.KarryCode.service.ICustomerService;
import org.springframework.stereotype.Service;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 8:22
 * @PackageName edu.KarryCode.service.impl
 * @ClassName CustomerServiceImpl
 * @Description TODO ICustomerService实现类
 * @Version 1.0
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
}
