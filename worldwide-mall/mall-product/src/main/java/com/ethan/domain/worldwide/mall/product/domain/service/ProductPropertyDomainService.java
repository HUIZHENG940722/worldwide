package com.ethan.domain.worldwide.mall.product.domain.service;

import cn.hutool.core.util.StrUtil;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.ProductPropertyBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.CreateProductPropertyBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.UpdateProductPropertyBo;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductPropertyRepository;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductPropertyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhenghui
 * @Description 商品规格领域服务
 * @Date 2022/8/22
 */
@Service
public class ProductPropertyDomainService {

    private ProductPropertyRepository productPropertyRepository;

    private ProductPropertyValueRepository productPropertyValueRepository;

    @Autowired
    public ProductPropertyDomainService(ProductPropertyRepository productPropertyRepository,
        ProductPropertyValueRepository productPropertyValueRepository) {
        this.productPropertyRepository = productPropertyRepository;
        this.productPropertyValueRepository = productPropertyValueRepository;
    }

    /**
     * 添加商品规格
     *
     * @param createProductPropertyBo
     * @return
     */
    @Transactional
    public Long add(CreateProductPropertyBo createProductPropertyBo) {
        // 1 核心校验
        // 1.1 校验规格键名称是否重复
        checkPropertyKeyName(null, createProductPropertyBo.getName());
        // 2 核心业务
        // 2.1 插入商品规格键
        Long productPropertyKeyId = productPropertyRepository.add(createProductPropertyBo);
        // 3 返回结果
        return productPropertyKeyId;
    }

    /**
     * 更新商品规格
     *
     * @param productPropertyBo
     * @param updateProductPropertyBo
     * @return
     */
    @Transactional
    public Boolean update(ProductPropertyBo productPropertyBo, UpdateProductPropertyBo updateProductPropertyBo) {
        // 1 核心校验
        // 1.1 校验商品规格键名称是否重复
        if (StrUtil.isNotBlank(updateProductPropertyBo.getName())) {
            checkPropertyKeyName(productPropertyBo, updateProductPropertyBo.getName());
        }
        // 2 核心业务
        // 2.1 更新商品规格键
        productPropertyRepository.updateById(productPropertyBo.getId(), updateProductPropertyBo);
        // 3 返回结果
        return true;
    }

    /**
     * 获取商品规格
     *
     * @param id
     * @return
     */
    public ProductPropertyBo getById(Long id) {
        // 1 核心校验
        // 2 核心业务
        // 2.1 获取商品规格
        ProductPropertyBo byId = productPropertyRepository.getById(id);
        // 3 返回结果
        return byId;
    }

    /**
     * 校验商品规格键名称是否重复
     *
     * @param productPropertyBo
     * @param name
     */
    private void checkPropertyKeyName(ProductPropertyBo productPropertyBo, String name) {
        ProductPropertyBo byName = productPropertyRepository.getByName(name);
        if (byName != null && (productPropertyBo != null || !productPropertyBo.getId().equals(byName.getId()))) {
            throw new RuntimeException("商品规格键名称重复");
        }
    }
}
