package com.ethan.domain.worldwide.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.ProductPropertyBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.CreateProductPropertyBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.UpdateProductPropertyBo;
import com.ethan.domain.worldwide.mall.product.domain.convert.ProductPropertyPoConvert;
import com.ethan.domain.worldwide.mall.product.infra.dao.ProductPropertyMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductPropertyPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品规格数据仓库
 * @Date 2022/8/22
 */
@Repository
public class ProductPropertyRepository {

    private ProductPropertyMapper productPropertyMapper;

    @Autowired
    public ProductPropertyRepository(ProductPropertyMapper productPropertyMapper) {
        this.productPropertyMapper = productPropertyMapper;
    }

    public Long add(CreateProductPropertyBo createProductPropertyKeyBo) {
        ProductPropertyPo productPropertyPo = ProductPropertyPoConvert.INSTANCE.crateToPo(createProductPropertyKeyBo);
        try {
            productPropertyMapper.insert(productPropertyPo);
        } catch (Exception e) {
            throw new RuntimeException("插入商品规格键数据异常");
        }
        return productPropertyPo.getId();
    }

    public Boolean updateById(Long id, UpdateProductPropertyBo updateProductPropertyKeyBo) {
        ProductPropertyPo productPropertyPo = ProductPropertyPoConvert.INSTANCE.updateToPo(updateProductPropertyKeyBo);
        productPropertyPo.setId(id);
        int update = 0;
        try {
            update = productPropertyMapper.updateById(productPropertyPo);
        } catch (Exception e) {
            throw new RuntimeException("更新商品规格键数据异常");
        }
        return update > 0;
    }

    public ProductPropertyBo getById(Long id) {
        ProductPropertyPo productPropertyPo;
        try {
            productPropertyPo = productPropertyMapper.selectById(id);
        } catch (Exception e) {
            throw new RuntimeException("查询商品规格数据异常");
        }
        return ProductPropertyPoConvert.INSTANCE.toBO(productPropertyPo);
    }

    public ProductPropertyBo getByName(String name) {
        LambdaQueryWrapper<ProductPropertyPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductPropertyPo::getName, name);
        List<ProductPropertyPo> productPropertyPos = null;
        try {
            productPropertyPos = productPropertyMapper.selectList(lambdaQueryWrapper);
        } catch (Exception e) {
            throw new RuntimeException("查询商品规格键数据异常");
        }
        return productPropertyPos.size() > 0 ? ProductPropertyPoConvert.INSTANCE.toBO(productPropertyPos.get(0)) : null;
    }

    private LambdaQueryWrapper<ProductPropertyPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductPropertyPo.class);
    }
}
