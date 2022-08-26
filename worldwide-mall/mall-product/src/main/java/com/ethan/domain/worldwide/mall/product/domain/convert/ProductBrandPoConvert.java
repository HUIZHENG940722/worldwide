package com.ethan.domain.worldwide.mall.product.domain.convert;

import com.ethan.domain.worldwide.mall.product.domain.bo.brand.ProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.CreateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.UpdateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductBrandPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;

/**
 * @Author zhenghui
 * @Description 商品品牌PO转换器
 * @Date 2022/8/22
 */
@Mapper
public interface ProductBrandPoConvert {

    ProductBrandPoConvert INSTANCE = Mappers.getMapper(ProductBrandPoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createdTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updatedTime", ignore = true),
        @Mapping(target = "updatedBy", ignore = true),
        @Mapping(target = "deleted", expression = "java(1)")
    })
    ProductBrandPo createToPo(CreateProductBrandBo createProductBrandBo);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createdTime", ignore = true),
        @Mapping(target = "updatedTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "createdBy", ignore = true),
        @Mapping(target = "deleted", ignore = true)
    })
    ProductBrandPo updateToPo(UpdateProductBrandBo updateProductBrandBo);

    ProductBrandBo toBo(ProductBrandPo productBrandPo);
}
