package com.ethan.domain.worldwide.mall.product.domain.service;

import com.ethan.domain.worldwide.mall.product.domain.bo.property.ProductPropertyValueBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.CreateProductPropertyValueBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.UpdateProductPropertyValueBo;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductPropertyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhenghui
 * @Description 商品规格值领域服务
 * @Date 2022/8/25
 */
@Service
public class ProductPropertyValueDomainService {

    private ProductPropertyValueRepository productPropertyValueRepository;

    @Autowired
    public ProductPropertyValueDomainService(ProductPropertyValueRepository productPropertyValueRepository) {
        this.productPropertyValueRepository = productPropertyValueRepository;
    }

    /**
     * 添加商品规格值
     *
     * @param propertyId
     * @param createPropertyValue
     * @return
     */
    public Long add(Long propertyId, CreateProductPropertyValueBo createPropertyValue) {
        // 1 核心校验
        // 1.1 校验商品规格值是否重复
        checkName(null, propertyId, createPropertyValue.getName());
        // 2 核心业务
        createPropertyValue.setPropertyId(propertyId);
        return productPropertyValueRepository.add(createPropertyValue);
        // 3 返回结果
    }

    /**
     * 更新商品规格值
     *
     * @param productPropertyValueBo
     * @param updateProductPropertyValueBo
     * @return
     */
    public Boolean update(ProductPropertyValueBo productPropertyValueBo, UpdateProductPropertyValueBo updateProductPropertyValueBo) {
        // 1 核心校验
        // 1.1 校验商品规格值是否重复
        checkName(productPropertyValueBo, productPropertyValueBo.getPropertyId(), updateProductPropertyValueBo.getName());
        // 2 核心业务
        return productPropertyValueRepository.updateById(productPropertyValueBo.getId(), updateProductPropertyValueBo);
        // 3 返回结果
    }

    /**
     * 校验商品规格值是否重复
     *
     * @param productPropertyValue
     * @param propertyId
     * @param name
     */
    private void checkName(ProductPropertyValueBo productPropertyValue, Long propertyId, String name) {
        ProductPropertyValueBo byPropertyIdAndName = productPropertyValueRepository.getByPropertyIdAndName(propertyId, name);
        if (byPropertyIdAndName != null && (productPropertyValue != null || !byPropertyIdAndName.getId().equals(productPropertyValue.getId()))) {
            throw new RuntimeException("商品规格值重复");
        }
    }
}
