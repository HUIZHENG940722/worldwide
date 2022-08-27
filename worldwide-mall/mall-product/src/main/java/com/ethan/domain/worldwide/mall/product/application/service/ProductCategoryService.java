package com.ethan.domain.worldwide.mall.product.application.service;

import com.ethan.domain.worldwide.mall.product.domain.bo.category.ProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.CreateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.UpdateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.service.ProductCategoryDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhenghui
 * @Description 商品分类应用服务
 * @Date 2022/8/26
 */
@Service
public class ProductCategoryService {

    private ProductCategoryDomainService productCategoryDomainService;

    @Autowired
    public ProductCategoryService(ProductCategoryDomainService productCategoryDomainService) {
        this.productCategoryDomainService = productCategoryDomainService;
    }

    public Long createCategory(CreateProductCategoryBo createProductCategoryBo) {
        // 1 业务校验
        // 2 业务逻辑
        // 2.1 初始化用户信息
        // TODO: 2022/8/26 目前没有构件用户体系，采用默认的用户编码1
        createProductCategoryBo.setCreatedBy(1L);
        // 2.2 创建商品分类
        return productCategoryDomainService.add(createProductCategoryBo);
        // 3 返回结果
    }

    public Boolean updateById(String id, UpdateProductCategoryBo updateProductCategoryBo) {
        // 1 业务校验
        // 1.1 当前用户是否能访问实例
        // TODO: 2022/8/27 目前没有构件用户体系，所以暂时不实现
        // 1.2 判断实例是否存在
        ProductCategoryBo orErrorById = productCategoryDomainService.getOrErrorById(Long.parseLong(id));
        // 2 业务逻辑
        // 2.1 初始化用户信息
        updateProductCategoryBo.setUpdatedBy(1L);
        // 2.2 更新商品分类
        return productCategoryDomainService.update(orErrorById, updateProductCategoryBo);
        // 3 返回结果
    }
}
