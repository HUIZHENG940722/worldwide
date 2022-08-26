package com.ethan.domain.worldwide.mall.product.infra.dao.po;

import com.baomidou.mybatisplus.annotation.*;
import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 商品SKU PO
 * @Date 2022/8/24
 */
@TableName(value = "product_sku")
@Data
@ToString(callSuper = true)
public class ProductSkuPo {

    /**
     * 商品SKU编码
     */
    @TableId
    private Long id;

    /**
     * 商品SPU编码
     */
    private Long spuId;

    /**
     * 规格键值JSON：{"2":["1","2","3"],"3":["4"]}
     */
    private String properties;

    /**
     * 销售价格：分
     */
    private Integer price;

    /**
     * 原价：分
     */
    private Integer originalPrice;

    /**
     * 成本价格：分
     */
    private Integer costPrice;

    /**
     * 条形码
     */
    private Integer barCode;

    /**
     * 图片地址
     */
    private String picUrl;

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
