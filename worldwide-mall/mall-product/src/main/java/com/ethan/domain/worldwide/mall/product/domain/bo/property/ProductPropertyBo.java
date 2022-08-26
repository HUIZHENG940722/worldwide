package com.ethan.domain.worldwide.mall.product.domain.bo.property;

import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 商品规格BO
 * @Date 2022/8/22
 */
@Data
public class ProductPropertyBo {

    /**
     * 商品规格编码
     */
    private Long id;

    /**
     * 商品规格名称
     */
    private String name;

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
    private StatusEnum status;
}
