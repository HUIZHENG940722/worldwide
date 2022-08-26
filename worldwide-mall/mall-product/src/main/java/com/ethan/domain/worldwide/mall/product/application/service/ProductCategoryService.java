package com.ethan.domain.worldwide.mall.product.application.service;

import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.CreateProductCategoryBo;
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
}
