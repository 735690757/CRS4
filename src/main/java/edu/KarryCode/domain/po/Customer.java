package edu.KarryCode.domain.po;

import lombok.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/26 下午 8:14
 * @PackageName edu.KarryCode.domain.po
 * @ClassName customer
 * @Description TODO 顾客实体类
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Customer {
    /**
     * 顾客id
     */
    private Integer id;
    /**
     * 顾客名字
     */
    private String name;
    /**
     * 顾客密码
     */
    private String password;
    /**
     * 顾客邮箱
     */
    private String email;
    /**
     * 顾客手机号
     */
    private String phone;
    /**
     * 顾客账户余额
     */
    private Double money;
}
