package edu.KarryCode.domain.po;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author KarryLiu
 * @Creed may all the beauty be blessed
 * @Date 2023/11/28 上午 10:03
 * @PackageName edu.KarryCode.domain.po
 * @ClassName SystemStartupLog
 * @Description TODO 系统启动日志实体
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Document("SystemStartupLog")
public class SystemStartupLog {
    /**
     * 启动主机地址
     */
    private String hostAddress;
    /**
     * 主机名
     */
    private String hostName;
    /**
     * 启动时间
     */
    private String startTime;
}
