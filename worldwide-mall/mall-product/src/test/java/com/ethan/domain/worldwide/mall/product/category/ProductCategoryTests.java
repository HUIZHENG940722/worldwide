package com.ethan.domain.worldwide.mall.product.category;

import com.ethan.domain.worldwide.mall.product.MallProductApplicationTests;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.CreateProductCategoryReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Author zhenghui
 * @Description 商品分类单元测试
 * @Date 2022/8/26
 */
public class ProductCategoryTests extends MallProductApplicationTests {

    private static final String CREATE_PRODUCT_CATEGORY = String.format("/product/category");

    private static final String UPDATE_PRODUCT_CATEGORY = String.format("/product/category/{id}");

    @Test
    @Order(value = 1)
    public void success() throws Exception {
        String id = post(CREATE_PRODUCT_CATEGORY, createSuccessDTO()).andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getContentAsString();
        Assertions.assertNotNull(id);
    }

    @Test
    @Order(value = 2)
    public void failWhenParentIdIllegal() throws Exception {
        post(CREATE_PRODUCT_CATEGORY, createFailDTOWhenParentIdIllegal()).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @Order(value = 3)
    public void failWhenNameRepeat() throws Exception {
        post(CREATE_PRODUCT_CATEGORY, createSuccessDTO()).andExpect(MockMvcResultMatchers.status().isConflict());
    }

    private CreateProductCategoryReq createSuccessDTO() {
        CreateProductCategoryReq createProductCategoryReq = new CreateProductCategoryReq();
        createProductCategoryReq.setParentId("0");
        createProductCategoryReq.setName("手机");
        createProductCategoryReq.setIcon("http://dummyimage.com/100x100");
        createProductCategoryReq.setBannerUrl("http://mwxulyl.st/jzpwi");
        createProductCategoryReq.setSort(1);
        createProductCategoryReq.setStatus(CreateProductCategoryReq.StatusEnum.NUMBER_1);
        createProductCategoryReq.setDescription("几乎每个人都要用的");
        return createProductCategoryReq;
    }


    private CreateProductCategoryReq createFailDTOWhenParentIdIllegal() {
        CreateProductCategoryReq createProductCategoryReq = new CreateProductCategoryReq();
        createProductCategoryReq.setParentId("100");
        createProductCategoryReq.setName("电脑");
        createProductCategoryReq.setIcon("http://dummyimage.com/100x100");
        createProductCategoryReq.setBannerUrl("http://mwxulyl.st/jzpwi");
        createProductCategoryReq.setSort(1);
        createProductCategoryReq.setStatus(CreateProductCategoryReq.StatusEnum.NUMBER_1);
        createProductCategoryReq.setDescription("几乎每个人都要用的");
        return createProductCategoryReq;
    }

}
