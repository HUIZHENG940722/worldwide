package com.ethan.domain.worldwide.mall.product.application.service;

import com.ethan.domain.worldwide.mall.product.domain.bo.brand.ProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.CreateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.UpdateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.service.ProductBrandDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhenghui
 * @Description 商品品牌应用服务
 * @Date 2022/10/24
 */
@Service
public class ProductBrandService {

    @Autowired
    private ProductBrandDomainService productBrandDomainService;

    public Long createBrand(CreateProductBrandBo createProductBrandBo) {
        // 1 校验
        // 2 业务
        // 2.1 初始化用户信息
        // TODO: 2022/10/24 目前没有构建用户体系
        createProductBrandBo.setCreatedBy(1L);
        return productBrandDomainService.add(createProductBrandBo);
        // 3 返回结果
    }

    public ProductBrandBo getById(long parseLong) {
        // 1 校验
        // 1.1 校验当前用户是否能访问实例
        // TODO: 2022/10/24 目前没有实现
        // 1.2 校验实例是否存在
        return productBrandDomainService.getOrErrorById(parseLong);
        // 2 业务
        // 3 返回结果
    }

    public Boolean updateById(long parseLong, UpdateProductBrandBo productBrandBo) {
        // 1 校验
        // 1.1 校验当前用户是否能访问实例
        // TODO: 2022/10/24 目前没有实现
        // 1.2 校验实例是否存在
        ProductBrandBo orErrorById = productBrandDomainService.getOrErrorById(parseLong);
        // 2 业务
        return productBrandDomainService.update(orErrorById, productBrandBo);
        // 3 返回结果
    }

    public Boolean deleteById(long parseLong) {
        // 1 校验
        // 1.1 校验当前用户是否能访问实例
        // TODO: 2022/10/24 目前没有实现
        // 1.2 校验实例是否存在
        productBrandDomainService.getOrErrorById(parseLong);
        // 2 业务
        return productBrandDomainService.deleteById(parseLong);
        // 3 返回结果
    }
}
