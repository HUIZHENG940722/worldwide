package com.ethan.domain.worldwide.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.ProductPropertyValueBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.CreateProductPropertyValueBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.UpdateProductPropertyValueBo;
import com.ethan.domain.worldwide.mall.product.domain.convert.ProductPropertyValuePoConvert;
import com.ethan.domain.worldwide.mall.product.infra.dao.ProductPropertyValueMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductPropertyValuePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品规格值数据仓库
 * @Date 2022/8/22
 */
@Repository
public class ProductPropertyValueRepository {

    private ProductPropertyValueMapper productPropertyValueMapper;

    @Autowired
    public ProductPropertyValueRepository(ProductPropertyValueMapper productPropertyValueMapper) {
        this.productPropertyValueMapper = productPropertyValueMapper;
    }

    /**
     * 添加商品规格值
     *
     * @param createPropertyValue
     * @return
     */
    public Long add(CreateProductPropertyValueBo createPropertyValue) {
        ProductPropertyValuePo productPropertyValue = ProductPropertyValuePoConvert.INSTANCE.createToPo(createPropertyValue);
        try {
            productPropertyValueMapper.insert(productPropertyValue);
        } catch (Exception e) {
            throw new RuntimeException("批量插入商品规格键数据异常");
        }
        return productPropertyValue.getId();
    }

    public Boolean updateById(Long id, UpdateProductPropertyValueBo updateProductPropertyValueBo) {
        ProductPropertyValuePo productPropertyValue = ProductPropertyValuePoConvert.INSTANCE.updateToPo(updateProductPropertyValueBo);
        productPropertyValue.setId(id);
        int update = 0;
        try {
            update = productPropertyValueMapper.updateById(productPropertyValue);
        } catch (Exception e) {
            throw new RuntimeException("更新商品规格键数据异常");
        }
        return update > 0;
    }

    /**
     * 获取商品规格值
     *
     * @param propertyId
     * @param name
     * @return
     */
    public ProductPropertyValueBo getByPropertyIdAndName(Long propertyId, String name) {
        LambdaQueryWrapper<ProductPropertyValuePo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductPropertyValuePo::getPropertyId, propertyId);
        lambdaQueryWrapper.eq(ProductPropertyValuePo::getName, name);
        List<ProductPropertyValuePo> productPropertyValuePoList;
        try {
            productPropertyValuePoList = productPropertyValueMapper.selectList(lambdaQueryWrapper);
        } catch (Exception e) {
            throw new RuntimeException("查询商品规格值数据异常");
        }
        return productPropertyValuePoList.size() > 0 ? ProductPropertyValuePoConvert.INSTANCE.toBo(productPropertyValuePoList.get(0)) : null;
    }

    /**
     * 根据商品规格获取规格值列表
     *
     * @param propertyId
     * @return
     */
    public List<ProductPropertyValueBo> getByPropertyId(Long propertyId) {
        LambdaQueryWrapper<ProductPropertyValuePo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductPropertyValuePo::getPropertyId, propertyId);
        List<ProductPropertyValuePo> productPropertyValuePoList;
        try {
            productPropertyValuePoList = productPropertyValueMapper.selectList(lambdaQueryWrapper);
        } catch (Exception e) {
            throw new RuntimeException("查询商品规格值数据异常");
        }
        return ProductPropertyValuePoConvert.INSTANCE.toBo(productPropertyValuePoList);
    }


    public Boolean deleteByPropertyId(Long propertyId) {
        LambdaQueryWrapper<ProductPropertyValuePo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductPropertyValuePo::getPropertyId, propertyId);
        int delete = 0;
        try {
            delete = productPropertyValueMapper.delete(lambdaQueryWrapper);
        } catch (Exception e) {
            throw new RuntimeException("删除商品规格值数据异常");
        }
        return delete > 0;
    }


    private LambdaUpdateWrapper<ProductPropertyValuePo> getLambdaUpdateWrapper() {
        return Wrappers.lambdaUpdate(ProductPropertyValuePo.class);
    }

    private LambdaQueryWrapper<ProductPropertyValuePo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductPropertyValuePo.class);
    }
}
