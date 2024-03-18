package edu.KarryCode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.KarryCode.domain.po.Admin;
import edu.KarryCode.mapper.AdminMapper;
import edu.KarryCode.service.IAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/20 下午 7:23
 * @PackageName edu.KarryCode.service.impl
 * @ClassName AdminServiceTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
class AdminServiceImplTest {
    @Autowired
    private IAdminService iAdminService;
    @Autowired
    private AdminMapper adminMapper;
    @Test
    void testSelectAdmin(){
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.eq("id",1);
        Admin one = iAdminService.getOne(adminQueryWrapper);
        System.out.println(one);
    }
    @Test
    public void testSelectUpdate(){
        LambdaQueryWrapper<Admin> eq = new LambdaQueryWrapper<Admin>().eq(Admin::getId, 1);
        Admin admin = adminMapper.selectOne(eq);
        admin.setPassword("123456");
        iAdminService.modifyInformation(admin);
    }

}