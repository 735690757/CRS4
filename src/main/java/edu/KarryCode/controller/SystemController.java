package edu.KarryCode.controller;

import edu.KarryCode.common.R;
import edu.KarryCode.domain.po.MessageLog;
import edu.KarryCode.domain.po.SystemStartupLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author KarryLiu
 * @Creed may all the beauty be blessed
 * @Date 2023/11/28 下午 12:17
 * @PackageName edu.KarryCode.controller
 * @ClassName SystemController
 * @Description TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    @Qualifier("CarRental3Mongodb")
    private MongoTemplate mongoTemplate;

    /**
     * @param request request
     * @return 启动日志列表
     * @Description 返回启动日志列表，根据启动时间倒序排列
     */
    @GetMapping("/SystemStartUpLog")
    public R<List<SystemStartupLog>> getSystemStartupLog(HttpServletRequest request) {
        Sort sort = Sort.by(Sort.Direction.DESC, "startTime");
        Query query = new Query().with(sort);
        query.limit(20);

        List<SystemStartupLog> systemStartupLogs = mongoTemplate.find(query, SystemStartupLog.class);
        return R.success(systemStartupLogs);
    }

    /**
     *
     * @param request request
     * @return 系统消息日志
     * @Description 按照OperationDate字段降序排列，返回消息日志
     */
    @GetMapping("/SystemMessageLog")
    public R<List<MessageLog>> getSystemMessage(HttpServletRequest request) {
        //OperationDate
        // 创建一个排序对象，按照OperationDate字段降序排列
        Sort sort = Sort.by(Sort.Direction.DESC, "OperationDate");

        Query query = new Query().with(sort);
        query.limit(40);
        List<MessageLog> all = mongoTemplate.find(query, MessageLog.class);
        return R.success(all);
    }
}
