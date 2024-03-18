package edu.KarryCode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.KarryCode.domain.po.Admin;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/20 下午 7:21
 * @PackageName edu.KarryCode.service
 * @ClassName IAdminService
 * @Description TODO 管理员服务类接口
 * @Version 1.0
 */

public interface IAdminService extends IService<Admin> {
    /**
     * @param admin 管理员对象
     * @return 插入是否成功
     */
    Boolean regisAdmin(Admin admin);

    /**
     * @param admin 管理员对象
     * @return 修改是否成功
     */
    Boolean modifyInformation(Admin admin);
}
