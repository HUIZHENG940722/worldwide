package com.ethan.domain.worldwide.mall.product.domain.convert;

import cn.hutool.core.util.StrUtil;
import com.ethan.domain.worldwide.mall.product.domain.bo.spu.ProductSpuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.spu.valueObject.CreateProductSpuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.spu.valueObject.UpdateProductSpuBo;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductSpuPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品SPU PO转换器
 * @Date 2022/8/23
 */
@Mapper
public interface ProductSpuPoConvert {

    ProductSpuPoConvert INSTANCE = Mappers.getMapper(ProductSpuPoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "picUrls", source = "picUrls", qualifiedByName = "listToString"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", ignore = true),
        @Mapping(target = "updatedBy", ignore = true),
        @Mapping(target = "deleted", expression = "java(1)")
    })
    ProductSpuPo createToPo(CreateProductSpuBo createProductSpuBo);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "categoryId", ignore = true),
        @Mapping(target = "brandId", ignore = true),
        @Mapping(target = "picUrls", source = "picUrls", qualifiedByName = "listToString"),
        @Mapping(target = "createTime", ignore = true),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "createdBy", ignore = true),
        @Mapping(target = "deleted", ignore = true)
    })
    ProductSpuPo updateToPo(UpdateProductSpuBo updateProductSpuBo);

    @Mappings({
        @Mapping(target = "picUrls", source = "picUrls", qualifiedByName = "stringToList")
    })
    List<ProductSpuBo> toBO(List<ProductSpuPo> productSpuPos);

    @Mappings({
        @Mapping(target = "picUrls", source = "picUrls", qualifiedByName = "stringToList")
    })
    ProductSpuBo toBO(ProductSpuPo productSpuPo);

    @Named(value = "listToString")
    default String listToString(List<String> list) {
        return list.size() > 0 ? StrUtil.join(",", list) : null;
    }

    @Named(value = "stringToList")
    default List<String> stringToList(String str) {
        return StrUtil.isNotBlank(str) ? Arrays.asList(str.split(",")) : null;
    }
}
