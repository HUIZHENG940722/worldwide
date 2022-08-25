package com.ethan.domain.worldwide.mall.product.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductSkuPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhenghui
 * @Description 商品SKU数据访问层
 * @Date 2022/8/24
 */
@Mapper
public interface ProductSkuMapper extends BaseMapper<ProductSkuPo> {
}
