package com.ethan.domain.worldwide.mall.product.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductPropertyPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhenghui
 * @Description 商品规格数据访问接口
 * @Date 2022/8/22
 */
@Mapper
public interface ProductPropertyMapper extends BaseMapper<ProductPropertyPo> {
}
