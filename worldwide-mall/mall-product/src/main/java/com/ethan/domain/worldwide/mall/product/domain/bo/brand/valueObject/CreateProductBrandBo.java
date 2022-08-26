package com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject;

import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;

/**
 * @Author zhenghui
 * @Description 创建商品品牌值对象
 * @Date 2022/8/22
 */
@Data
public class CreateProductBrandBo {

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
     * 创建者
     */
    private Long createdBy;


    /**
     * 开启状态
     */
    private StatusEnum status;
}
