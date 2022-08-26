package com.ethan.domain.worldwide.mall.product.infra.dao.po;

import com.baomidou.mybatisplus.annotation.*;
import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 商品分类PO
 * @Date 2022/8/19
 */
@TableName(value = "product_category")
@Data
@ToString(callSuper = true)
public class ProductCategoryPo {

    /**
     * 分类编码
     */
    @TableId
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
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updatedTime;

    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     * 更新者
     */
    @TableField(fill = FieldFill.UPDATE)
    private Long updatedBy;

    /**
     * 是否删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;

    /**
     * 开启状态
     */
    @TableField(fill = FieldFill.INSERT)
    private StatusEnum status;
}
