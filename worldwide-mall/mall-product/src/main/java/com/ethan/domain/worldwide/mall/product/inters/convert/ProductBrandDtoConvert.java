package com.ethan.domain.worldwide.mall.product.inters.convert;

import com.ethan.domain.worldwide.mall.product.domain.bo.brand.ProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.CreateProductBrandBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.brand.valueObject.UpdateProductBrandBo;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.CreateProductBrandReq;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.ProductBrandRsp;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.UpdateProductBrandReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author zhenghui
 * @Description 商品品牌DTO转换器
 * @Date 2022/10/24
 */
@Mapper
public interface ProductBrandDtoConvert {
    ProductBrandDtoConvert INSTANCE = Mappers.getMapper(ProductBrandDtoConvert.class);

    CreateProductBrandBo toCreateBo(CreateProductBrandReq createProductBrandReq);

    ProductBrandRsp toRsp(ProductBrandBo productBrandBo);

    UpdateProductBrandBo toUpdateBo(UpdateProductBrandReq updateProductBrandReq);
}
