package com.ethan.domain.worldwide.mall.product.domain.bo.spu;

import com.ethan.domain.worldwide.mall.product.infra.enums.StatusEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品SPU BO
 * @Date 2022/8/23
 */
@Data
public class ProductSpuBo {

    /**
     * 商品SPU编码
     */
    private Long id;

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
     * 商品分类
     */
    private Long categoryId;

    /**
     * 品牌编码
     */
    private Long brandId;

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
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

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
