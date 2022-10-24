package com.ethan.domain.worldwide.mall.product.domain.service;

import cn.hutool.core.util.StrUtil;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.ProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.CreateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.UpdateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhenghui
 * @Description 商品品牌领域服务
 * @Date 2022/8/22
 */
@Service
public class ProductBrandDomainService {

    private ProductBrandRepository productBrandRepository;

    @Autowired
    public ProductBrandDomainService(ProductBrandRepository productBrandRepository) {
        this.productBrandRepository = productBrandRepository;
    }

    /**
     * 创建商品品牌
     *
     * @param createProductBrandBo
     * @return
     */
    @Transactional
    public Long add(CreateProductBrandBo createProductBrandBo) {
        // 1 核心校验
        // 1.1 校验商品品牌是否重复
        checkName(null, createProductBrandBo.getName());
        // 2 核心业务
        return productBrandRepository.add(createProductBrandBo);
        // 3 返回结果
    }

    /**
     * 更新商品品牌
     *
     * @param productBrandBo
     * @param updateProductBrandBo
     * @return
     */
    @Transactional
    public Boolean update(ProductBrandBo productBrandBo, UpdateProductBrandBo updateProductBrandBo) {
        // 1 核心校验
        // 1.1 校验商品品牌是否重复
        if (StrUtil.isNotBlank(updateProductBrandBo.getName())) {
            checkName(productBrandBo, updateProductBrandBo.getName());
        }
        // 2 核心业务
        return productBrandRepository.updateById(productBrandBo.getId(), updateProductBrandBo);
        // 3 返回结果
    }

    /**
     * 获取商品品牌
     *
     * @param id
     * @return
     */
    public ProductBrandBo getById(Long id) {
        // 1 核心校验
        // 2 核心业务
        return productBrandRepository.getById(id);
        // 3 返回结果
    }

    public ProductBrandBo getOrErrorById(Long id) {
        ProductBrandBo byId = productBrandRepository.getById(id);
        if (byId == null) {
            throw new RuntimeException("商品品牌编码无效");
        }
        return byId;
    }

    /**
     * 删除商品品牌
     *
     * @param id
     * @return
     */
    @Transactional
    public Boolean deleteById(Long id) {
        // 1 核心校验
        // 2 核心业务
        return productBrandRepository.deleteById(id);
        // 3 返回结果
    }


    /**
     * 校验商品品牌名称是否重复
     *
     * @param productBrandBo
     * @param name
     */
    private void checkName(ProductBrandBo productBrandBo, String name) {
        ProductBrandBo byName = productBrandRepository.getByName(name);
        if (byName != null && (productBrandBo == null
            || productBrandBo.getId().equals(byName.getId()))) {
            throw new RuntimeException("商品品牌名称重复");
        }
    }
}
