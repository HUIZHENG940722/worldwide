package com.ethan.domain.worldwide.mall.product.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductCategoryPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhenghui
 * @Description 商品分类数据访问层
 * @Date 2022/8/19
 */
@Mapper
public interface ProductCategoryMapper extends BaseMapper<ProductCategoryPo> {
}
