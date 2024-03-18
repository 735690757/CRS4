package edu.KarryCode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.KarryCode.domain.po.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/20 下午 7:18
 * @PackageName edu.KarryCode.mapper
 * @ClassName AdminMapper
 * @Description TODO 管理员表Mapper，这里只负责复杂查询，简单查询由MybatisPlus接管
 * @Version 1.0
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * @param admin 管理员对象
     * @return 影响数量
     */
    int updateAdminSelective(Admin admin);
}
