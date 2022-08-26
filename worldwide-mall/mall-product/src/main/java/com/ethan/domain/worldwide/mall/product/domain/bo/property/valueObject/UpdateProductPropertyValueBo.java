package com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject;

import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;

/**
 * @Author zhenghui
 * @Description 更新商品规格值值对象
 * @Date 2022/8/25
 */
@Data
public class UpdateProductPropertyValueBo {

    /**
     * 规格值名称
     */
    private String name;

    /**
     * 更新者
     */
    private Long updatedBy;

    /**
     * 开启状态
     */
    private StatusEnum status;
}
