package com.ethan.domain.worldwide.mall.product.infra.dao.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 商品SPU PO
 * @Date 2022/8/23
 */
@TableName(value = "product_spu")
@Data
@ToString(callSuper = true)
public class ProductSpuPo {

    /**
     * 商品SPU编码
     */
    private Long id;

    /**
     * 商品SPU名称
     */
    private String name;

    /**
     * 卖点
     */
    private String sellPoint;

    /**
     * 商品SPU描述
     */
    private String description;

    /**
     * 商品分类
     */
    private Long categoryId;

    /**
     * 品牌编码
     */
    private Long brandId;

    /**
     * 商品SPU主体地址，业务层是对应的List
     */
    private String picUrls;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 初始点赞数量
     */
    private Integer likeCount;

    /**
     * 单价：分
     */
    private Integer price;

    /**
     * 商品库存
     */
    private Integer quantity;

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
