package edu.KarryCode.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.KarryCode.domain.po.Admin;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/25 上午 10:34
 * @PackageName edu.KarryCode.mapper
 * @ClassName AdminMapperTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;
    @Test
    public void test(){
        LambdaQueryWrapper<Admin> eq = new LambdaQueryWrapper<Admin>().eq(Admin::getId, 1);
        Admin admin = adminMapper.selectOne(eq);
        System.out.println(admin);
        admin.setNickname("");
        admin.setPassword("");
        System.out.println(admin);
        int i = adminMapper.updateAdminSelective(admin);
        System.out.println(i);
    }
}