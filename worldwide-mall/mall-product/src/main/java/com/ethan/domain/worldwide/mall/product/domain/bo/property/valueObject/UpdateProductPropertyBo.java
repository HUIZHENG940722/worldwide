package com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject;

import lombok.Data;

/**
 * @Author zhenghui
 * @Description 更新商品规格值对象
 * @Date 2022/8/22
 */
@Data
public class UpdateProductPropertyBo {

    /**
     * 商品规格名称
     */
    private String name;

    /**
     * 更新者
     */
    private Long updatedBy;

    /**
     * 开启状态
     */
    private Integer status;
}
