package com.ethan.domain.worldwide.mall.product.domain.service;

import com.ethan.domain.worldwide.mall.product.domain.bo.sku.ProductSkuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.sku.valueObject.CreateProductSkuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.sku.valueObject.UpdateProductSkuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.spu.ProductSpuBo;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductSkuRepository;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductSpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品SKU领域服务
 * @Date 2022/8/24
 */
@Service
public class ProductSkuDomainService {

    private ProductSkuRepository productSkuRepository;

    private ProductSpuRepository productSpuRepository;

    @Autowired
    public ProductSkuDomainService(ProductSkuRepository productSkuRepository, ProductSpuRepository productSpuRepository) {
        this.productSkuRepository = productSkuRepository;
        this.productSpuRepository = productSpuRepository;
    }

    /**
     * 添加商品SKU
     *
     * @param spuId
     * @param createProductSkuBo
     * @return
     */
    @Transactional
    public Long add(Long spuId, CreateProductSkuBo createProductSkuBo) {
        // 1 核心校验
        // 1.1 校验商品spu是否存在
        checkSpuId(spuId);
        // 2 核心业务
        // 2.1 添加商品SKU
        createProductSkuBo.setSpuId(spuId);
        return productSkuRepository.add(createProductSkuBo);
        // 3 返回结果
    }

    /**
     * 更新商品SKU
     *
     * @param productSkuBo
     * @param updateProductSkuBo
     * @return
     */
    @Transactional
    public Boolean update(ProductSkuBo productSkuBo, UpdateProductSkuBo updateProductSkuBo) {
        // 1 核心校验
        // 2 核心业务
        return productSkuRepository.updateById(productSkuBo.getId(), updateProductSkuBo);
        // 3 返回结果
    }


    /**
     * 获取商品SPU对应的SKU列表
     *
     * @param spuId
     * @return
     */
    public List<ProductSkuBo> listBySpuId(Long spuId) {
        // 1 核心校验
        // 1.1 校验商品SPU
        checkSpuId(spuId);
        // 2 核心业务
        return productSkuRepository.listBySpuId(spuId);
        // 3 返回结果
    }

    private void checkSpuId(Long spuId) {
        ProductSpuBo byId = productSpuRepository.getById(spuId);
        if (byId == null) {
            throw new RuntimeException("商品SPU编码无效");
        }
    }
}
