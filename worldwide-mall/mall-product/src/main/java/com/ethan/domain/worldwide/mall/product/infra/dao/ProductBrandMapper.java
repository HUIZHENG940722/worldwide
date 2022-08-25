package com.ethan.domain.worldwide.mall.product.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductBrandPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhenghui
 * @Description 商品品牌数据访问层
 * @Date 2022/8/22
 */
@Mapper
public interface ProductBrandMapper extends BaseMapper<ProductBrandPo> {
}
