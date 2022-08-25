package com.ethan.domain.worldwide.mall.product.inters.controller;

import com.ethan.domain.worldwide.openapi.interfaces.api.MallProductCategoryApi;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.CreateProductCategoryReq;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.ProductCategoryRsp;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.UpdateProductCategoryReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhenghui
 * @Description 商品分类用户接口实现
 * @Date 2022/8/24
 */
@RestController
public class ProductCategoryController implements MallProductCategoryApi {
    @Override
    public ResponseEntity<String> createCategory(CreateProductCategoryReq createProductCategoryReq) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> deleteCategory(String id) {
        return null;
    }

    @Override
    public ResponseEntity<ProductCategoryRsp> getCategory(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> updateCategory(String id, UpdateProductCategoryReq updateProductCategoryReq) {
        return null;
    }
}
