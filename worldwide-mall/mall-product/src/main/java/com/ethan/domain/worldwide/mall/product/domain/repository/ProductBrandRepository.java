package com.ethan.domain.worldwide.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.ProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.CreateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.UpdateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.convert.ProductBrandPoConvert;
import com.ethan.domain.worldwide.mall.product.infra.dao.ProductBrandMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductBrandPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品品牌数据仓库
 * @Date 2022/8/22
 */
@Repository
public class ProductBrandRepository {

    private ProductBrandMapper productBrandMapper;

    @Autowired
    public ProductBrandRepository(ProductBrandMapper productBrandMapper) {
        this.productBrandMapper = productBrandMapper;
    }

    public Long add(CreateProductBrandBo createProductBrandBo) {
        ProductBrandPo toPo = ProductBrandPoConvert.INSTANCE.createToPo(createProductBrandBo);
        try {
            productBrandMapper.insert(toPo);
        } catch (Exception e) {
            throw new RuntimeException("插入商品品牌数据异常");
        }
        return toPo.getId();
    }

    public Boolean updateById(Long id, UpdateProductBrandBo updateProductBrandBo) {
        ProductBrandPo productBrandPo = ProductBrandPoConvert.INSTANCE.updateToPo(updateProductBrandBo);
        productBrandPo.setId(id);
        int update = 0;
        try {
            update = productBrandMapper.updateById(productBrandPo);
        } catch (Exception e) {
            throw new RuntimeException("更新商品品牌数据异常");
        }
        return update > 0;
    }

    public ProductBrandBo getById(Long id) {
        ProductBrandPo productBrandPo;
        try {
            productBrandPo = productBrandMapper.selectById(id);
        } catch (Exception e) {
            throw new RuntimeException("查询商品品牌数据异常");
        }
        return ProductBrandPoConvert.INSTANCE.toBo(productBrandPo);
    }

    public ProductBrandBo getByName(String name) {
        LambdaQueryWrapper<ProductBrandPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductBrandPo::getName, name);
        List<ProductBrandPo> productBrandPos;
        try {
            productBrandPos = productBrandMapper.selectList(lambdaQueryWrapper);
        } catch (Exception e) {
            throw new RuntimeException("查询商品品牌数据异常");
        }
        return productBrandPos.size() > 0 ? ProductBrandPoConvert.INSTANCE.toBo(productBrandPos.get(0)) : null;
    }

    public Boolean deleteById(Long id) {
        int delete = 0;
        try {
            delete = productBrandMapper.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("删除商品品牌数据异常");
        }
        return delete > 0;
    }

    private LambdaQueryWrapper<ProductBrandPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductBrandPo.class);
    }
}
