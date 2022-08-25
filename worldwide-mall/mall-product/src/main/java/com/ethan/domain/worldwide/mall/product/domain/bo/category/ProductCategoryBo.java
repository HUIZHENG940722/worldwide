package com.ethan.domain.worldwide.mall.product.domain.bo.category;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 商品分类BO
 * @Date 2022/8/19
 */
@Data
@ToString(callSuper = true)
public class ProductCategoryBo {

    /**
     * 分类编码
     */
    private Long id;

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
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建者
     */
    private Long createdBy;

    /**
     * 更新者
     */
    private Long updatedBy;

    /**
     * 开启状态
     */
    private Integer status;
}
