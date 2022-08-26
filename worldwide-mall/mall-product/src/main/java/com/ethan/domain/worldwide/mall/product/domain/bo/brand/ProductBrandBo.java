package com.ethan.domain.worldwide.mall.product.domain.bo.brand;

import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 商品品牌BO
 * @Date 2022/8/22
 */
@Data
public class ProductBrandBo {

    /**
     * 商品品牌编码
     */
    private Long id;

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
