package com.ethan.domain.worldwide.mall.product.domain.convert;

import com.ethan.domain.worldwide.mall.product.domain.bo.property.ProductPropertyValueBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.CreateProductPropertyValueBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.UpdateProductPropertyValueBo;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductPropertyValuePo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品规格值转换器
 * @Date 2022/8/22
 */
@Mapper
public interface ProductPropertyValuePoConvert {

    ProductPropertyValuePoConvert INSTANCE = Mappers.getMapper(ProductPropertyValuePoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", ignore = true),
        @Mapping(target = "updatedBy", ignore = true),
        @Mapping(target = "deleted", expression = "java(1)")
    })
    ProductPropertyValuePo createToPo(CreateProductPropertyValueBo createProductPropertyValueBo);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "propertyId", ignore = true),
        @Mapping(target = "createTime", ignore = true),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "createdBy", ignore = true),
        @Mapping(target = "deleted", ignore = true)
    })
    ProductPropertyValuePo updateToPo(UpdateProductPropertyValueBo updateProductPropertyValueBo);
    ProductPropertyValueBo toBo(ProductPropertyValuePo productPropertyValuePo);

    List<ProductPropertyValueBo> toBo(List<ProductPropertyValuePo> productPropertyValuePoList);
}
