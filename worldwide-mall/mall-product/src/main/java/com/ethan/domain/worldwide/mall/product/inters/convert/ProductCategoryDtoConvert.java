package com.ethan.domain.worldwide.mall.product.inters.convert;

import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.CreateProductCategoryBo;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.CreateProductCategoryReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Author zhenghui
 * @Description 商品分类DTO转换器
 * @Date 2022/8/26
 */
@Mapper
public interface ProductCategoryDtoConvert {

    ProductCategoryDtoConvert INSTANCE = Mappers.getMapper(ProductCategoryDtoConvert.class);


    @Mappings({
        @Mapping(target = "createdBy", ignore = true)
    })
    CreateProductCategoryBo toCreateBo(CreateProductCategoryReq createProductCategoryReq);
}
