package edu.KarryCode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.KarryCode.domain.po.Admin;
import edu.KarryCode.mapper.AdminMapper;
import edu.KarryCode.service.IAdminService;
import org.springframework.stereotype.Service;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/20 下午 7:21
 * @PackageName edu.KarryCode.service.impl
 * @ClassName AdminService
 * @Description TODO IAdminService实现类
 * @Version 1.0
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Override
    public Boolean regisAdmin(Admin admin) {
        String username = admin.getUsername();
        LambdaQueryWrapper<Admin> adminLambdaQueryWrapper = new LambdaQueryWrapper<>();
        adminLambdaQueryWrapper.eq(Admin::getUsername,username);
        Admin adminExist = baseMapper.selectOne(adminLambdaQueryWrapper);
        if (adminExist != null){
            return false;
        }
        int insert = baseMapper.insert(admin);
        return insert > 0;

    }

    @Override
    public Boolean modifyInformation(Admin admin) {
        if (admin == null){
            return false;
        }
        int i = baseMapper.updateAdminSelective(admin);
        return i > 0;
    }
}
