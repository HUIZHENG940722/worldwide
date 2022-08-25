package com.ethan.domain.worldwide.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.worldwide.mall.product.domain.bo.sku.ProductSkuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.sku.valueObject.CreateProductSkuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.sku.valueObject.UpdateProductSkuBo;
import com.ethan.domain.worldwide.mall.product.domain.convert.ProductSkuPoConvert;
import com.ethan.domain.worldwide.mall.product.infra.dao.ProductSkuMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductSkuPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品SKU数据仓库
 * @Date 2022/8/24
 */
@Repository
public class ProductSkuRepository {

    private ProductSkuMapper productSkuMapper;

    @Autowired
    public ProductSkuRepository(ProductSkuMapper productSkuMapper) {
        this.productSkuMapper = productSkuMapper;
    }

    public Long add(CreateProductSkuBo createProductSkuBo) {
        ProductSkuPo productSkuPo = ProductSkuPoConvert.INSTANCE.createToPo(createProductSkuBo);
        try {
            productSkuMapper.insert(productSkuPo);
        } catch (Exception e) {
            throw new RuntimeException("插入商品SKU数据异常");
        }
        return productSkuPo.getId();
    }

    public Boolean updateById(Long id, UpdateProductSkuBo updateProductSkuBo) {
        ProductSkuPo productSkuPo = ProductSkuPoConvert.INSTANCE.updateToPo(updateProductSkuBo);
        productSkuPo.setId(id);
        int update = 0;
        try {
            update = productSkuMapper.updateById(productSkuPo);
        } catch (Exception e) {
            throw new RuntimeException("更新商品SKU数据异常");
        }
        return update > 0;
    }

    public List<ProductSkuBo> listBySpuId(Long spuId) {
        LambdaQueryWrapper<ProductSkuPo> lambdaQueryWrap = getLambdaQueryWrap();
        lambdaQueryWrap.eq(ProductSkuPo::getSpuId, spuId);
        List<ProductSkuPo> productSkuPos;
        try {
            productSkuPos = productSkuMapper.selectList(lambdaQueryWrap);
        } catch (Exception e) {
            throw new RuntimeException("查询商品SKU数据异常");
        }
        return ProductSkuPoConvert.INSTANCE.toBo(productSkuPos);
    }

    private LambdaQueryWrapper<ProductSkuPo> getLambdaQueryWrap() {
        return Wrappers.lambdaQuery(ProductSkuPo.class);
    }
}
