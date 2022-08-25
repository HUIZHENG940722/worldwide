package com.ethan.domain.worldwide.mall.product.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductPropertyValuePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品规格值数据访问接口
 * @Date 2022/8/22
 */
@Mapper
public interface ProductPropertyValueMapper extends BaseMapper<ProductPropertyValuePo> {

    Integer insertBatchSomeColumn(List<ProductPropertyValuePo> entities);
}
