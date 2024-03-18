package edu.KarryCode.domain.vo;

import lombok.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/25 下午 7:52
 * @PackageName edu.KarryCode.domain.vo
 * @ClassName ECodeVO
 * @Description TODO 邮箱验证码值对象
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ECodeVO {
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 邮箱验证码
     */
    private String eCode;
}
