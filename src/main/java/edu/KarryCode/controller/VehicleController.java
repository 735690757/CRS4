package edu.KarryCode.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.KarryCode.common.R;
import edu.KarryCode.domain.po.RankEntity;
import edu.KarryCode.domain.po.Vehicle;
import edu.KarryCode.domain.vo.PageVO;
import edu.KarryCode.domain.vo.PageVehicleVO;
import edu.KarryCode.service.IVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.List;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/22 下午 2:08
 * @PackageName edu.KarryCode.controller
 * @ClassName VehicleController
 * @Description TODO 汽车订单数据接口
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private IVehicleService iVehicleService;
    @Autowired
    @Qualifier("CarRental3Mongodb")
    private MongoTemplate mongoTemplate;

    /**
     * @param request request
     * @param pageVO  值对象
     * @return PageVehicleVO值对象
     * @Description 分页式获取车辆数据
     */
    @PostMapping("/page")
    public R<PageVehicleVO> getVehiclePage(HttpServletRequest request, @RequestBody PageVO pageVO) {
        Integer adminID = (Integer) request.getSession().getAttribute("admin");
        if (adminID == null) {
            return R.error("未登录");
        }
        Long sizePage = pageVO.getSizePage();
        Long currentPage = pageVO.getCurrentPage();
        System.out.println(pageVO);

        Page<Vehicle> vehiclePage = new Page<>();
        vehiclePage.setCurrent(currentPage);
        vehiclePage.setSize(sizePage);

        Page<Vehicle> page = iVehicleService.page(vehiclePage);
        List<Vehicle> records = page.getRecords();
        long total = page.getTotal();
        PageVehicleVO pageVehicleVO = PageVehicleVO.builder()
                .vehicleList(records)
                .totalCount(total).build();
        return R.success(pageVehicleVO);
    }

    /**
     * @param request request
     * @param vehicle 被修改的车辆对象
     * @return 返回成功与否
     * @Description 更新车辆数据
     */
    @PostMapping("/update")
    public R<String> updateVehicle(HttpServletRequest request, @RequestBody Vehicle vehicle) {
        Integer adminID = (Integer) request.getSession().getAttribute("admin");
        if (adminID == null) {
            return R.error("未登录");
        }
        try {
            R updateR = iVehicleService.updateVehicle(vehicle);
            System.out.println(updateR.getCode());
            if (updateR.getCode() == 1) {
                return R.success("更新成功");
            } else {
                return R.error(updateR.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("服务器错误啦！");
        }
    }

    /**
     * @param request request
     * @param vehicle 添加的车辆对象
     * @return 添加成功与否
     * @Description 添加车辆
     */
    @PutMapping("/add")
    public R<String> addVehicle(HttpServletRequest request, @RequestBody Vehicle vehicle) {
        Integer adminID = (Integer) request.getSession().getAttribute("admin");
        if (adminID == null) {
            return R.error("未登录");
        }
        try {
            R addVehicleR = iVehicleService.addVehicle(vehicle);
            if (addVehicleR.getCode() == 1) {
                return R.success("添加成功");
            } else {
                return R.error(addVehicleR.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("服务器错误啦！");
        }
    }

    /**
     * @param request request
     * @param id      车辆id
     * @return 删除成功与否
     * @Description 根据id删除车辆
     */
    @DeleteMapping("/delete/{id}")
    public R<String> deleteVehicle(HttpServletRequest request, @PathVariable Integer id) {
        Integer adminID = (Integer) request.getSession().getAttribute("admin");
        if (adminID == null) {
            return R.error("未登录");
        }
        try {
            R deleteVehicleR = iVehicleService.deleteVehicle(id);
            if (deleteVehicleR.getCode() == 1) {
                return R.success("操作成功！");
            } else {
                return R.error(deleteVehicleR.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("服务器出差了~~");
        }
    }

    /**
     * @param request   request
     * @param fuzzyName 模糊的内容
     * @return 车辆列表
     * @Description 模糊查询，可以自适应查询车牌号和车辆名
     */
    @PostMapping("/fuzzyQuery")
    public R<List<Vehicle>> getFuzzyQuery(HttpServletRequest request, @RequestBody String fuzzyName) {
        String decode = URLDecoder.decode(fuzzyName);
        if (decode.endsWith("=")) {
            decode = decode.substring(0, decode.length() - 1);
        }
        System.out.println(decode);
        List<Vehicle> vehicleFuzzy = iVehicleService.getVehicleFuzzy(decode);
        for (Vehicle vehicle : vehicleFuzzy) {
            System.out.println(vehicle);
        }
        if (vehicleFuzzy == null) {
            return R.error("未输入数据");
        }
        return R.success(vehicleFuzzy);
    }

    /**
     * @param request request
     * @return 根据score倒序排列
     * @Description 获取车辆排行榜
     */
    @GetMapping("/rank")
    public R<List<RankEntity>> getRank(HttpServletRequest request){
        // 创建查询
        Query query = new Query();
        // 指定排序字段和排序方向
        Sort sort = Sort.by(Sort.Direction.DESC, "score");
        query.with(sort);
        List<RankEntity> all = mongoTemplate.find(query,RankEntity.class);
        return R.success(all);
    }
}
