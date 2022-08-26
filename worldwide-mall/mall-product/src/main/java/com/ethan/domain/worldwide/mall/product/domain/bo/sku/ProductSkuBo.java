package com.ethan.domain.worldwide.mall.product.domain.bo.sku;

import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 商品SKU BO
 * @Date 2022/8/24
 */
@Data
public class ProductSkuBo {

    /**
     * 商品SKU编码
     */
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
     * 是否删除
     */
    private Integer deleted;

    /**
     * 开启状态
     */
    private StatusEnum status;
}
