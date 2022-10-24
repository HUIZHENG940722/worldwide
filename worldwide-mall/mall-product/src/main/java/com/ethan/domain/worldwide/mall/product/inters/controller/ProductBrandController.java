package com.ethan.domain.worldwide.mall.product.inters.controller;

import com.ethan.domain.worldwide.mall.product.application.service.ProductBrandService;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.ProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.CreateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.UpdateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.inters.convert.ProductBrandDtoConvert;
import com.ethan.domain.worldwide.openapi.interfaces.api.MallProductBrandApi;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.CreateProductBrandReq;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.ProductBrandRsp;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.UpdateProductBrandReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhenghui
 * @Description 商品品牌用户接口
 * @Date 2022/10/24
 */
@RestController
public class ProductBrandController implements MallProductBrandApi {

    @Autowired
    private ProductBrandService productBrandService;

    @Override
    public ResponseEntity<String> createBrand(CreateProductBrandReq createProductBrandReq) {
        // 1 数据转换
        CreateProductBrandBo createProductBrandBo = ProductBrandDtoConvert.INSTANCE.toCreateBo(createProductBrandReq);
        // 2 业务
        Long brandId = productBrandService.createBrand(createProductBrandBo);
        // 3 返回结果
        return new ResponseEntity<>(String.valueOf(brandId), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Boolean> deleteBrand(String id) {
        // 1 数据转换
        // 2 业务
        Boolean deleted = productBrandService.deleteById(Long.parseLong(id));
        // 3 返回结果
        return new ResponseEntity<>(deleted, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ProductBrandRsp> getBrand(String id) {
        // 1 数据转换
        // 2 业务
        ProductBrandBo productBrandBo = productBrandService.getById(Long.parseLong(id));
        // 3 返回结果
        ProductBrandRsp productBrandRsp = ProductBrandDtoConvert.INSTANCE.toRsp(productBrandBo);
        return new ResponseEntity<>(productBrandRsp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> updateBrand(String id, UpdateProductBrandReq updateProductBrandReq) {
        // 1 数据转换
        UpdateProductBrandBo productBrandBo = ProductBrandDtoConvert.INSTANCE.toUpdateBo(updateProductBrandReq);
        // 2 业务
        Boolean updated = productBrandService.updateById(Long.parseLong(id), productBrandBo);
        // 3 返回结果
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
