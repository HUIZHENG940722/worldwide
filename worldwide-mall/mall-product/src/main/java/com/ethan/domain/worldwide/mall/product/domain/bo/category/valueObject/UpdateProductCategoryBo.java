package com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject;

import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;

/**
 * @Author zhenghui
 * @Description 更新商品分类值对象
 * @Date 2022/8/19
 */
@Data
public class UpdateProductCategoryBo {

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类图标
     */
    private String icon;

    /**
     * 分类图片链接
     */
    private String bannerUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 分类描述
     */
    private String description;


    /**
     * 更新者
     */
    private Long updatedBy;

    /**
     * 开启状态
     */
    private StatusEnum status;
}
