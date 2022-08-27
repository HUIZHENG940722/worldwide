package com.ethan.domain.worldwide.mall.product.inters.convert;

import cn.hutool.core.date.DateUtil;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.ProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.CreateProductCategoryBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.category.valueObject.UpdateProductCategoryBo;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.CreateProductCategoryReq;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.ProductCategoryRsp;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.UpdateProductCategoryReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;

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

    @Mappings({
        @Mapping(target = "updatedBy", ignore = true)
    })
    UpdateProductCategoryBo toUpdate(UpdateProductCategoryReq updateProductCategoryReq);

    ProductCategoryRsp toDto(ProductCategoryBo productCategoryBo);

    default String dateToString(Date date) {
        return DateUtil.format(date, "yyyy-MM-dd hh:mm:ss");
    }
}
