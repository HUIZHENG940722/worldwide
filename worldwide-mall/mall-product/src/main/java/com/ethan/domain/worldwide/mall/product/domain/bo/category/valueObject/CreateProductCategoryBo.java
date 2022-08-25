package com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 创建商品分类值对象
 * @Date 2022/8/22
 */
@Data
@ToString(callSuper = true)
public class CreateProductCategoryBo {

    /**
     * 父分类编码
     */
    private Long parentId;

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
     * 创建者
     */
    private Long createdBy;

    /**
     * 开启状态
     */
    private Integer status;
}
