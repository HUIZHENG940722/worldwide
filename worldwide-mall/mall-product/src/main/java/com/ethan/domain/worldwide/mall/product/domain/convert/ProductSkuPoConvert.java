package com.ethan.domain.worldwide.mall.product.domain.convert;

import com.ethan.domain.worldwide.mall.product.domain.bo.sku.ProductSkuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.sku.valueObject.CreateProductSkuBo;
import com.ethan.domain.worldwide.mall.product.domain.bo.sku.valueObject.UpdateProductSkuBo;
import com.ethan.domain.worldwide.mall.product.infra.dao.po.ProductSkuPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 商品SKU PO转换器
 * @Date 2022/8/24
 */
@Mapper
public interface ProductSkuPoConvert {

    ProductSkuPoConvert INSTANCE = Mappers.getMapper(ProductSkuPoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "spuId", ignore = true),
        @Mapping(target = "createTime", expression = "java(new Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", ignore = true),
        @Mapping(target = "createdBy", ignore = true),
        @Mapping(target = "deleted", ignore = true)
    })
    ProductSkuPo createToPo(CreateProductSkuBo createProductSkuBo);


    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createTime", ignore = true),
        @Mapping(target = "updateTime", expression = "java(new Date(System.currentTimeMillis()))"),
        @Mapping(target = "updatedBy", ignore = true),
        @Mapping(target = "deleted", expression = "java(1)")
    })
    ProductSkuPo updateToPo(UpdateProductSkuBo updateProductSkuBo);

    ProductSkuBo toBo(ProductSkuPo productSkuBo);

    List<ProductSkuBo> toBo(List<ProductSkuPo> productSkuPos);
}
