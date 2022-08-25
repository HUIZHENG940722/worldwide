package com.ethan.domain.worldwide.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.worldwide.mall.product.domain.bo.spu.ProductSpuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.spu.valueObject.CreateProductSpuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.spu.valueObject.UpdateProductSpuBo;
import com.ethan.domain.worldwide.mall.product.domain.convert.ProductSpuPoConvert;
import com.ethan.domain.worldwide.mall.product.infra.dao.ProductSpuMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductSpuPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品SPU数据仓库
 * @Date 2022/8/23
 */
@Repository
public class ProductSpuRepository {

    private ProductSpuMapper productSpuMapper;

    @Autowired
    public ProductSpuRepository(ProductSpuMapper productSpuMapper) {
        this.productSpuMapper = productSpuMapper;
    }

    public Long add(CreateProductSpuBo createProductSpuBo) {
        ProductSpuPo productSpuPo = ProductSpuPoConvert.INSTANCE.createToPo(createProductSpuBo);
        try {
            productSpuMapper.insert(productSpuPo);
        } catch (Exception e) {
            throw new RuntimeException("插入商品SPU数据异常");
        }
        return productSpuPo.getId();
    }

    public Boolean updateById(Long id, UpdateProductSpuBo updateProductSpuBo) {
        ProductSpuPo productSpuPo = ProductSpuPoConvert.INSTANCE.updateToPo(updateProductSpuBo);
        productSpuPo.setId(id);
        int update = 0;
        try {
            update = productSpuMapper.updateById(productSpuPo);
        } catch (Exception e) {
            throw new RuntimeException("更新商品SPU数据异常");
        }
        return update > 0;
    }

    public ProductSpuBo getById(Long id) {
        ProductSpuPo productSpuPo;
        try {
            productSpuPo = productSpuMapper.selectById(id);
        } catch (Exception e) {
            throw new RuntimeException("查询商品SPU数据异常");
        }
        return ProductSpuPoConvert.INSTANCE.toBO(productSpuPo);
    }


    public ProductSpuBo getByCategoryIdAndName(Long categoryId, String name) {
        LambdaQueryWrapper<ProductSpuPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductSpuPo::getCategoryId, categoryId);
        lambdaQueryWrapper.eq(ProductSpuPo::getName, name);
        List<ProductSpuPo> productSpuPos;
        try {
            productSpuPos = productSpuMapper.selectList(lambdaQueryWrapper);
        } catch (Exception e) {
            throw new RuntimeException("查询商品SPU数据异常");
        }
        return ProductSpuPoConvert.INSTANCE.toBO(productSpuPos);
    }

    public Boolean deleteById(Long id) {
        int delete = 0;
        try {
            delete = productSpuMapper.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("删除商品SPU数据异常");
        }
        return delete > 0;
    }

    private LambdaQueryWrapper<ProductSpuPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductSpuPo.class);
    }
}
