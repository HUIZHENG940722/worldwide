package com.ethan.domain.worldwide.mall.product.domain.convert;

import com.ethan.domain.worldwide.mall.product.domain.bo.property.ProductPropertyBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.CreateProductPropertyBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.property.valueObject.UpdateProductPropertyBo;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductPropertyPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Author zhenghui
 * @Description 商品规格PO转换器
 * @Date 2022/8/22
 */
@Mapper
public interface ProductPropertyPoConvert {
    ProductPropertyPoConvert INSTANCE = Mappers.getMapper(ProductPropertyPoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createTime", expression = "java(new Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", ignore = true),
        @Mapping(target = "updatedBy", ignore = true),
        @Mapping(target = "deleted", expression = "java(1)")
    })
    ProductPropertyPo crateToPo(CreateProductPropertyBo createProductPropertyKeyBo);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createTime", ignore = true),
        @Mapping(target = "updateTime", expression = "java(new Date(System.currentTimeMillis()))"),
        @Mapping(target = "createdBy", ignore = true),
        @Mapping(target = "deleted", ignore = true)
    })
    ProductPropertyPo updateToPo(UpdateProductPropertyBo updateProductPropertyKeyBo);

    ProductPropertyBo toBO(ProductPropertyPo productPropertyPo);
}
