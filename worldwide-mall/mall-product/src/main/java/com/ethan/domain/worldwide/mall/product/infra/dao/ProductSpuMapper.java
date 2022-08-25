package com.ethan.domain.worldwide.mall.product.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductSpuPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhenghui
 * @Description 商品SPU数据访问接口
 * @Date 2022/8/24
 */
@Mapper
public interface ProductSpuMapper extends BaseMapper<ProductSpuPo> {
}
