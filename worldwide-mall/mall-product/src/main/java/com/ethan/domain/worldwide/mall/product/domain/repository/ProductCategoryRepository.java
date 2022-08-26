package com.ethan.domain.worldwide.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.worldwide.common.util.WorldwideExceptionUtil;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.ProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.CreateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.UpdateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.convert.ProductCategoryPoConvert;
import com.ethan.domain.worldwide.mall.product.infra.dao.ProductCategoryMapper;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductCategoryPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品分类数据仓库
 * @Date 2022/8/19
 */
@Repository
public class ProductCategoryRepository {

    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    public ProductCategoryRepository(ProductCategoryMapper productCategoryMapper) {
        this.productCategoryMapper = productCategoryMapper;
    }

    public Long add(CreateProductCategoryBo createProductCategoryMap) {
        ProductCategoryPo productCategoryPo = ProductCategoryPoConvert.INSTANCE.createToPo(createProductCategoryMap);
        try {
            productCategoryMapper.insert(productCategoryPo);
        } catch (Exception e) {
            WorldwideExceptionUtil.asserts(HttpStatus.INTERNAL_SERVER_ERROR, "插入商品分类数据异常");
        }
        return productCategoryPo.getId();
    }

    public Boolean updateById(Long id, UpdateProductCategoryBo updateProductCategoryBo) {
        ProductCategoryPo productCategoryPo = ProductCategoryPoConvert.INSTANCE.updateToPo(updateProductCategoryBo);
        productCategoryPo.setId(id);
        try {
            productCategoryMapper.updateById(productCategoryPo);
        } catch (Exception e) {
            WorldwideExceptionUtil.asserts(HttpStatus.INTERNAL_SERVER_ERROR, "更新商品分类数据异常");
        }
        return true;
    }

    public ProductCategoryBo getById(Long id) {
        LambdaQueryWrapper<ProductCategoryPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductCategoryPo::getId, id);
        ProductCategoryPo productCategoryPo = null;
        try {
            productCategoryPo = productCategoryMapper.selectOne(lambdaQueryWrapper);
        } catch (Exception e) {
            WorldwideExceptionUtil.asserts(HttpStatus.INTERNAL_SERVER_ERROR, "查询商品分类数据异常");
        }
        return ProductCategoryPoConvert.INSTANCE.toBo(productCategoryPo);
    }

    public ProductCategoryBo getByParentIdAndName(Long parentId, String name) {
        LambdaQueryWrapper<ProductCategoryPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductCategoryPo::getParentId, parentId);
        lambdaQueryWrapper.eq(ProductCategoryPo::getName, name);
        List<ProductCategoryPo> productCategoryPos = null;
        try {
            productCategoryPos = productCategoryMapper.selectList(lambdaQueryWrapper);
        } catch (Exception e) {
            WorldwideExceptionUtil.asserts(HttpStatus.INTERNAL_SERVER_ERROR, "查询商品分类数据异常");
        }
        return productCategoryPos.size() > 0 ? ProductCategoryPoConvert.INSTANCE.toBo(productCategoryPos.get(0)) : null;
    }

    public List<ProductCategoryBo> getChildListByParentId(Long parentId) {
        LambdaQueryWrapper<ProductCategoryPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductCategoryPo::getParentId, parentId);
        List<ProductCategoryPo> productCategoryPos = null;
        try {
            productCategoryPos = productCategoryMapper.selectList(lambdaQueryWrapper);
        } catch (Exception e) {
            WorldwideExceptionUtil.asserts(HttpStatus.INTERNAL_SERVER_ERROR, "查询商品子分类数据异常");
        }
        return ProductCategoryPoConvert.INSTANCE.toBo(productCategoryPos);
    }

    public Boolean deleteById(Long id) {
        int delete = 0;
        try {
            delete = productCategoryMapper.deleteById(id);
        } catch (Exception e) {
            WorldwideExceptionUtil.asserts(HttpStatus.INTERNAL_SERVER_ERROR, "逻辑删除商品分类数据异常");
        }
        return delete != 0;
    }

    private LambdaQueryWrapper<ProductCategoryPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductCategoryPo.class);
    }
}
