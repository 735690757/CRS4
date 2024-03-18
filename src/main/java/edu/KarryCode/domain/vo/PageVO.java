package edu.KarryCode.domain.vo;

import lombok.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/22 下午 2:13
 * @PackageName edu.KarryCode.domain.vo
 * @ClassName PageVO
 * @Description TODO 分页值对象
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageVO {
    /**
     * 总页数
     */
    private Long allPage;
    /**
     * 当前页
     */
    private Long currentPage;
    /**
     * 当页尺寸
     */
    private Long sizePage;
}
