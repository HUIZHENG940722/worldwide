package com.ethan.domain.worldwide.mall.product.infra.dao.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 商品规格键PO
 * @Date 2022/8/22
 */
@TableName(value = "product_property")
@Data
@ToString(callSuper = true)
public class ProductPropertyPo {

    /**
     * 商品规格编码
     */
    @TableId
    private Long id;

    /**
     * 商品规格名称
     */
    private String name;

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
    private Integer status;
}
