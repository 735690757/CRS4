package edu.KarryCode.domain.po;

import edu.KarryCode.domain.eo.MessageActivity;
import edu.KarryCode.domain.eo.Permissions;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/9/23 上午 9:58
 * @PackageName edu.KarryCode.entity
 * @ClassName MessageLog
 * @Description TODO 消息操作日志
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@Document("MessageLog")
public class MessageLog {
    /**
     * 操作者
     */
    private String Operator;
    /**
     * 操作内容
     */
    private MessageActivity messageActivity;
    /**
     * 操作日期
     */
    private String OperationDate;
    /**
     * 操作权限
     */
    private Permissions Permissions;
    /**
     * 操作是否可见
     */
    private Boolean Visible;
    /**
     * 操作是否成功
     */
    private boolean Successful;
}
