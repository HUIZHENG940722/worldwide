package com.ethan.domain.worldwide.mall.product.domain.bo.sku.valueObject;

import lombok.Data;

/**
 * @Author zhenghui
 * @Description 更新商品SKU值对象
 * @Date 2022/8/24
 */
@Data
public class UpdateProductSkuBo {

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
     * 更新者
     */
    private Long updatedBy;

    /**
     * 开启状态
     */
    private Integer status;
}
