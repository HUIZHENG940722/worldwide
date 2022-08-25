package com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject;

import lombok.Data;

/**
 * @Author zhenghui
 * @Description 创建商品规格值对象
 * @Date 2022/8/22
 */
@Data
public class CreateProductPropertyValueBo {

    /**
     * 规格编码
     */
    private Long propertyId;

    /**
     * 规格值名称
     */
    private String name;

    /**
     * 创建者
     */
    private Long createdBy;

    /**
     * 开启状态
     */
    private Integer status;
}
