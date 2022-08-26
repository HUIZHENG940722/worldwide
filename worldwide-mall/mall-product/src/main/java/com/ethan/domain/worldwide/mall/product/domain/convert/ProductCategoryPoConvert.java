package com.ethan.domain.worldwide.mall.product.domain.convert;

import com.ethan.domain.worldwide.mall.product.domain.bo.category.ProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.CreateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.UpdateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductCategoryPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品分类PO转换器
 * @Date 2022/8/19
 */
@Mapper
public interface ProductCategoryPoConvert {
    ProductCategoryPoConvert INSTANCE = Mappers.getMapper(ProductCategoryPoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createdTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updatedTime", ignore = true),
        @Mapping(target = "updatedBy", ignore = true),
        @Mapping(target = "deleted", expression = "java(1)")
    })
    ProductCategoryPo createToPo(CreateProductCategoryBo createProductCategoryBo);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "parentId", ignore = true),
        @Mapping(target = "createdTime", ignore = true),
        @Mapping(target = "updatedTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "createdBy", ignore = true),
        @Mapping(target = "deleted", ignore = true)
    })
    ProductCategoryPo updateToPo(UpdateProductCategoryBo updateProductCategoryBo);

    ProductCategoryBo toBo(ProductCategoryPo productCategoryPo);

    List<ProductCategoryBo> toBo(List<ProductCategoryPo> productCategoryPos);
}
