package com.ethan.domain.worldwide.mall.product.domain.bo.spu.valueObject;

import lombok.Data;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 更新商品SPU值对象
 * @Date 2022/8/23
 */
@Data
public class UpdateProductSpuBo {

    /**
     * 商品SPU名称
     */
    private String name;

    /**
     * 卖点
     */
    private String sellPoint;

    /**
     * 商品SPU描述
     */
    private String description;

    /**
     * 商品SPU主体地址，在数据库以String形式存在，中间逗号隔开
     */
    private List<String> picUrls;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 初始点赞数量
     */
    private Integer likeCount;

    /**
     * 单价：分
     */
    private Integer price;

    /**
     * 商品库存
     */
    private Integer quantity;

    /**
     * 更新者
     */
    private Long updatedBy;

    /**
     * 开启状态
     */
    private Integer status;
}
