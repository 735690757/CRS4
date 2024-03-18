package edu.KarryCode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.KarryCode.domain.po.Customer;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 8:17
 * @PackageName edu.KarryCode.mapper
 * @ClassName CustomerMapper
 * @Description TODO 顾客表Mapper，这里只负责复杂查询，简单查询由MybatisPlus接管
 * @Version 1.0
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
