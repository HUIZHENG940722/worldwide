package com.ethan.domain.worldwide.mall.product.inters.controller;

import com.ethan.domain.worldwide.mall.product.application.service.ProductCategoryService;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.ProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.CreateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.UpdateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.inters.convert.ProductCategoryDtoConvert;
import com.ethan.domain.worldwide.openapi.interfaces.api.MallProductCategoryApi;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.CreateProductCategoryReq;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.ProductCategoryRsp;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.UpdateProductCategoryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhenghui
 * @Description 商品分类用户接口实现
 * @Date 2022/8/24
 */
@RestController
public class ProductCategoryController implements MallProductCategoryApi {

    private ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @Override
    public ResponseEntity<String> createCategory(CreateProductCategoryReq createProductCategoryReq) {
        // 1 数据转换
        CreateProductCategoryBo createProductCategoryBo = ProductCategoryDtoConvert.INSTANCE.toCreateBo(createProductCategoryReq);
        // 2 业务逻辑
        Long categoryId = productCategoryService.createCategory(createProductCategoryBo);
        // 3 返回结果
        return new ResponseEntity<>(String.valueOf(categoryId), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Boolean> deleteCategory(String id) {
        // 1 数据转换
        // 2 业务逻辑
        Boolean delete = productCategoryService.deleteById(id);
        // 3 返回结果
        return new ResponseEntity<>(delete, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ProductCategoryRsp> getCategory(String id) {
        // 1 数据转换
        // 2 业务逻辑
        ProductCategoryBo productCategoryBo = productCategoryService.getById(id);
        // 3 返回结果
        ProductCategoryRsp productCategoryRsp = ProductCategoryDtoConvert.INSTANCE.toDto(productCategoryBo);
        return new ResponseEntity<>(productCategoryRsp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> updateCategory(String id, UpdateProductCategoryReq updateProductCategoryReq) {
        // 1 数据转换
        UpdateProductCategoryBo updateProductCategoryBo = ProductCategoryDtoConvert.INSTANCE.toUpdate(updateProductCategoryReq);
        // 2 业务逻辑
        Boolean update = productCategoryService.updateById(id, updateProductCategoryBo);
        // 3 返回结果
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
}
