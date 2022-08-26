package com.ethan.domain.worldwide.mall.product.infra.dao.po;

import com.baomidou.mybatisplus.annotation.*;
import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 商品品牌PO
 * @Date 2022/8/22
 */
@TableName(value = "product_brand")
@Data
@ToString(callSuper = true)
public class ProductBrandPo {

    /**
     * 商品品牌编码
     */
    @TableId
    private Long id;

    /**
     * 商品品牌名称
     */
    private String name;

    /**
     * 商品品牌链接
     */
    private String bannerUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 品牌描述
     */
    private String description;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

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
