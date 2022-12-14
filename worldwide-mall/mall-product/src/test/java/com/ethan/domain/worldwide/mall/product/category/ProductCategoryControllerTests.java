package com.ethan.domain.worldwide.mall.product.category;

import com.ethan.domain.worldwide.mall.product.MallProductApplicationTests;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.CreateProductCategoryReq;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.UpdateProductCategoryReq;
import org.junit.jupiter.api.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Author zhenghui
 * @Description 商品分类单元测试
 * @Date 2022/8/26
 */
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class ProductCategoryControllerTests extends MallProductApplicationTests {

    private static final String CREATE_PRODUCT_CATEGORY = String.format("/product/category");

    private static final String UPDATE_PRODUCT_CATEGORY = String.format("/product/category/{id}");

    private static final String GET_PRODUCT_CATEGORY = String.format("/product/category/{id}");


    private static final String DELETE_PRODUCT_CATEGORY = String.format("/product/category/{id}");

    private static String categoryId, categoryId2;

    @Test
    @Order(value = 1)
    public void createSuccess() throws Exception {
        String id = post(CREATE_PRODUCT_CATEGORY, createSuccessDTO()).andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getContentAsString();
        categoryId = id;
        Assertions.assertNotNull(id);
    }

    @Test
    @Order(value = 2)
    public void createSuccess2() throws Exception {
        CreateProductCategoryReq successDTO = createSuccessDTO();
        successDTO.setParentId(categoryId);
        successDTO.setName("华为手机");
        String id = post(CREATE_PRODUCT_CATEGORY, successDTO).andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getContentAsString();
        categoryId2 = id;
        Assertions.assertNotNull(id);
    }

    @Test
    @Order(value = 3)
    public void createSuccess3() throws Exception {
        CreateProductCategoryReq successDTO = createSuccessDTO();
        successDTO.setName("笔记本");
        post(CREATE_PRODUCT_CATEGORY, successDTO).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @Order(value = 4)
    public void createFailWhenParentIdIllegal() throws Exception {
        CreateProductCategoryReq successDTO = createSuccessDTO();
        successDTO.setParentId("100");
        successDTO.setName("电脑");
        post(CREATE_PRODUCT_CATEGORY, successDTO).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @Order(value = 5)
    public void createFailWhenNameRepeat() throws Exception {
        post(CREATE_PRODUCT_CATEGORY, createSuccessDTO()).andExpect(MockMvcResultMatchers.status().isConflict());
    }

    @Test
    @Order(value = 6)
    public void updateSuccess() throws Exception {
        put(UPDATE_PRODUCT_CATEGORY.replace("{id}", categoryId), updateSuccessDTO()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(value = 7)
    public void updateFailWhenNameRepeat() throws Exception {
        UpdateProductCategoryReq updateProductCategoryReq = updateSuccessDTO();
        updateProductCategoryReq.setName("笔记本");
        put(UPDATE_PRODUCT_CATEGORY.replace("{id}", categoryId), updateProductCategoryReq).andExpect(MockMvcResultMatchers.status().isConflict());
    }

    @Test
    @Order(value = 8)
    public void getSuccess() throws Exception {
        get(GET_PRODUCT_CATEGORY.replace("{id}", categoryId)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(value = 9)
    public void getFailWhenIdIllegal() throws Exception {
        get(GET_PRODUCT_CATEGORY.replace("{id}", "100")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @Order(value = 10)
    public void deleteFailWhenExistChild() throws Exception {
        del(DELETE_PRODUCT_CATEGORY.replace("{id}", categoryId)).andExpect(MockMvcResultMatchers.status().isConflict());
    }

    @Test
    @Order(value = 11)
    public void deleteSuccess() throws Exception {
        del(DELETE_PRODUCT_CATEGORY.replace("{id}", categoryId2)).andExpect(MockMvcResultMatchers.status().isNoContent());
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


    private UpdateProductCategoryReq updateSuccessDTO() {
        UpdateProductCategoryReq updateProductCategoryReq = new UpdateProductCategoryReq();
        updateProductCategoryReq.setName("电脑");
        updateProductCategoryReq.setIcon("http://dummyimage.com/100x100");
        updateProductCategoryReq.setBannerUrl("http://mwxulyl.st/jzpwi");
        updateProductCategoryReq.setSort(1);
        updateProductCategoryReq.setStatus(UpdateProductCategoryReq.StatusEnum.NUMBER_1);
        updateProductCategoryReq.setDescription("几乎每个人都要用的");
        return updateProductCategoryReq;
    }
}
