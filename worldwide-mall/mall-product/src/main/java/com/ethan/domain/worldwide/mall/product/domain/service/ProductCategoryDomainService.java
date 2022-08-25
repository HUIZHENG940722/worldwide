package com.ethan.domain.worldwide.mall.product.domain.service;

import cn.hutool.core.util.StrUtil;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.ProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.CreateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.UpdateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品分类领域服务
 * @Date 2022/8/19
 */
@Service
public class ProductCategoryDomainService {

    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryDomainService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    /**
     * 添加商品分类
     *
     * @param createProductCategoryBo
     * @return
     */
    @Transactional
    public Long add(CreateProductCategoryBo createProductCategoryBo) {
        // 1 核心校验
        // 1.1 校验父分类编码是否存在
        checkParentId(createProductCategoryBo.getParentId());
        // 1.2 校验平级商品分类名称是否重复
        checkName(null, createProductCategoryBo.getParentId(), createProductCategoryBo.getName());
        // 2 核心业务
        return productCategoryRepository.add(createProductCategoryBo);
        // 3 返回结果
    }

    /**
     * 更新商品分类
     *
     * @param productCategoryBo
     * @param updateProductCategoryBo
     * @return
     */
    @Transactional
    public Boolean update(ProductCategoryBo productCategoryBo, UpdateProductCategoryBo updateProductCategoryBo) {
        // 1 核心校验
        // 1.1 校验平级商品分类名称是否重复
        if (StrUtil.isNotBlank(updateProductCategoryBo.getName())) {
            checkName(productCategoryBo.getId(), productCategoryBo.getParentId(), updateProductCategoryBo.getName());
        }
        // 2 核心业务
        // 3 返回结果
        return productCategoryRepository.updateById(productCategoryBo.getId(), updateProductCategoryBo);
    }

    /**
     * 查询商品分类
     *
     * @param id
     * @return
     */
    public ProductCategoryBo getById(Long id) {
        // 1 核心校验
        // 2 核心业务
        return productCategoryRepository.getById(id);
        // 3 返回结果
    }

    /**
     * 删除商品分类
     *
     * @param id
     * @return
     */
    @Transactional
    public Boolean deleteById(Long id) {
        // 1 核心校验
        // 1.1 校验分类是否存在
        checkId(id);
        // 1.2 校验是否存在子分类
        if (isExistChild(id)) {
            throw new RuntimeException("存在子分类不允许删除");
        }
        // 2 核心业务
        return productCategoryRepository.deleteById(id);
        // 3 返回结果
    }

    /**
     * 校验父商品分类ID
     *
     * @param parentId
     */
    private void checkParentId(Long parentId) {
        if (parentId != 0) {
            ProductCategoryBo productCategoryBo = getById(parentId);
            if (productCategoryBo == null) {
                throw new RuntimeException("商品父分类id无效");
            }
        }
    }

    /**
     * 校验是否存在孩子节点
     *
     * @param parentId
     */
    private Boolean isExistChild(Long parentId) {
        List<ProductCategoryBo> productCategoryBoList = productCategoryRepository.getChildListByParentId(parentId);
        if (productCategoryBoList.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 校验商品分类id
     *
     * @param id
     */
    private void checkId(Long id) {
        ProductCategoryBo productCategoryBo = getById(id);
        if (productCategoryBo == null) {
            throw new RuntimeException("商品分类编码不存在");
        }
    }

    /**
     * 校验商品分类名称
     *
     * @param id       商品分类编码
     * @param parentId 父商品分类编码
     * @param name     商品分类名称
     */
    private void checkName(Long id, Long parentId, String name) {
        ProductCategoryBo byParentIdAndName = productCategoryRepository.getByParentIdAndName(parentId, name);
        if (byParentIdAndName != null && (id == null ||
            !id.equals(byParentIdAndName.getId()))) {
            throw new RuntimeException("商品分类名称重复");
        }
    }
}
