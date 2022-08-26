package com.ethan.domain.worldwide.mall.product.domain.service;

import cn.hutool.core.util.StrUtil;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.ProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.ProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.sku.ProductSkuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.spu.ProductSpuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.spu.valueObject.CreateProductSpuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.spu.valueObject.UpdateProductSpuBo;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductBrandRepository;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductCategoryRepository;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductSkuRepository;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductSpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品SPU领域服务
 * @Date 2022/8/23
 */
@Service
public class ProductSpuDomainService {

    private ProductSpuRepository productSpuRepository;

    private ProductSkuRepository productSkuRepository;

    private ProductCategoryRepository productCategoryRepository;

    private ProductBrandRepository productBrandRepository;

    @Autowired
    public ProductSpuDomainService(ProductSpuRepository productSpuRepository,
        ProductSkuRepository productSkuRepository, ProductCategoryRepository productCategoryRepository,
        ProductBrandRepository productBrandRepository) {
        this.productSpuRepository = productSpuRepository;
        this.productSkuRepository = productSkuRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.productBrandRepository = productBrandRepository;
    }

    /**
     * 添加商品SPU
     *
     * @param createProductSpuBo
     * @return
     */
    @Transactional
    public Long add(CreateProductSpuBo createProductSpuBo) {
        // 1 核心校验
        // 1.1 校验商品分类是否存在
        checkCategoryId(createProductSpuBo.getCategoryId());
        // 1.2 校验商品品牌是否存在
        checkBrandId(createProductSpuBo.getBrandId());
        // 1.1 校验商品SPU名称是否重复
        checkName(null, createProductSpuBo.getCategoryId(), createProductSpuBo.getBrandId(), createProductSpuBo.getName());
        // 2 核心业务
        // 2.1 创建商品SPU
        return productSpuRepository.add(createProductSpuBo);
        // 3 返回结果
    }

    /**
     * 更新商品SPU
     *
     * @param productSpuBo
     * @param updateProductSpuBo
     * @return
     */
    @Transactional
    public Boolean update(ProductSpuBo productSpuBo, UpdateProductSpuBo updateProductSpuBo) {
        // 1 核心校验
        // 1.1 校验商品SPU名称是否重复
        if (StrUtil.isNotBlank(updateProductSpuBo.getName())) {
            checkName(productSpuBo, productSpuBo.getCategoryId(), productSpuBo.getBrandId(), updateProductSpuBo.getName());
        }
        // 2 核心业务
        // 2.1 更新商品SPU
        return productSpuRepository.updateById(productSpuBo.getId(), updateProductSpuBo);
        // 3 返回结果
    }

    /**
     * 删除商品SPU
     *
     * @param id
     * @return
     */
    @Transactional
    public Boolean deleteById(Long id) {
        // 1 核心校验
        // 1.1 校验商品SPU是否存在
        checkId(id);
        // 1.2 校验是否存在库存SKU
        checkIsExistSkuListBySpuId(id);
        // 2 核心业务
        return productSpuRepository.deleteById(id);
        // 3 返回结果
    }

    /**
     * 校验商品SPU编码
     *
     * @param id
     */
    private void checkId(Long id) {
        ProductSpuBo productSpuBo = productSpuRepository.getById(id);
        if (productSpuBo == null) {
            throw new RuntimeException("商品SPU编码无效");
        }
    }

    /**
     * 校验商品分类
     *
     * @param categoryId
     */
    private void checkCategoryId(Long categoryId) {
        ProductCategoryBo byId = productCategoryRepository.getById(categoryId);
        if (byId == null) {
            throw new RuntimeException("商品分类编码无效");
        }
    }

    /**
     * 校验商品品牌
     *
     * @param brandId
     */
    private void checkBrandId(Long brandId) {
        ProductBrandBo byId = productBrandRepository.getById(brandId);
        if (byId == null) {
            throw new RuntimeException("商品品牌编码无效");
        }
    }

    /**
     * 校验商品SPU名称是否重复
     *
     * @param productSpuBo
     * @param categoryId
     * @param name
     */
    private void checkName(ProductSpuBo productSpuBo, Long categoryId, Long brandId, String name) {
        ProductSpuBo byCategoryIdAndName = productSpuRepository.getByCategoryIdAndBrandIdAndName(categoryId, brandId, name);
        if (byCategoryIdAndName == null || (productSpuBo == null && !productSpuBo.getId().equals(byCategoryIdAndName.getId()))) {
            throw new RuntimeException("商品SPU名称重复");
        }
    }

    /**
     * 校验商品SPU是否存在库存
     *
     * @param spuId
     */
    private void checkIsExistSkuListBySpuId(Long spuId) {
        if (isExistSkuListBySpuId(spuId)) {
            throw new RuntimeException("商品SPU存在库存");
        }
    }

    /**
     * 是否存在库存
     *
     * @param spuId
     */
    private Boolean isExistSkuListBySpuId(Long spuId) {
        List<ProductSkuBo> productSkuBos = productSkuRepository.listBySpuId(spuId);
        if (productSkuBos.size() > 0) {
            return true;
        }
        return false;
    }
}
