package com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject;

import lombok.Data;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 创建商品规格值对象
 * @Date 2022/8/22
 */
@Data
public class CreateProductPropertyBo {

    /**
     * 商品规格名称
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
