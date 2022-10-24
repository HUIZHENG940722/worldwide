package com.ethan.domain.worldwide.mall.product.brand;

import com.ethan.domain.worldwide.mall.product.MallProductApplicationTests;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.CreateProductBrandReq;
import com.ethan.domain.worldwide.openapi.interfaces.api.dto.UpdateProductBrandReq;
import org.junit.jupiter.api.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Author zhenghui
 * @Description 商品品牌单元测试
 * @Date 2022/10/24
 */
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class ProductBrandControllerTests extends MallProductApplicationTests {

    private static final String CREATE_PRODUCT_BRAND = String.format("/product/brand");

    private static final String UPDATE_PRODUCT_BRAND = String.format("/product/brand/{id}");

    private static final String GET_PRODUCT_BRAND = String.format("/product/brand/{id}");


    private static final String DELETE_PRODUCT_BRAND = String.format("/product/brand/{id}");
    private static String brandId;

    @Test
    @Order(value = 1)
    public void createSuccess() throws Exception {
        brandId = post(CREATE_PRODUCT_BRAND, createSuccessDTO()).andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse().getContentAsString();
        Assertions.assertNotNull(brandId);
    }

    @Test
    @Order(value = 2)
    public void createSuccess2() throws Exception {
        CreateProductBrandReq successDTO = createSuccessDTO();
        successDTO.setName("其他");
        String id = post(CREATE_PRODUCT_BRAND, successDTO).andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse().getContentAsString();
        Assertions.assertNotNull(id);
    }

    @Test
    @Order(value = 3)
    public void updateSuccess() throws Exception {
        put(UPDATE_PRODUCT_BRAND.replace("{id}", brandId), updateSuccessDTO()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(value = 4)
    public void getSuccess() throws Exception {
        get(GET_PRODUCT_BRAND.replace("{id}", brandId)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(value = 5)
    public void deleteSuccess() throws Exception {
        del(DELETE_PRODUCT_BRAND.replace("{id}", brandId)).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    private CreateProductBrandReq createSuccessDTO() {
        CreateProductBrandReq createProductBrandReq = new CreateProductBrandReq();
        createProductBrandReq.setName("众志部王专");
        createProductBrandReq.setBannerUrl("http://npbrh.mo/ykxvututd");
        createProductBrandReq.setSort(1);
        createProductBrandReq.setStatus(CreateProductBrandReq.StatusEnum.NUMBER_1);
        createProductBrandReq.setDescription("品合从角石们声即电入法满大称许。导复响世过响它性认提说元及组位复运。米时毛见加今万地成你求厂也数广。放许员内达情院图今高只况动响方置件。变根平众线叫料务品当华住平。土九采团写行对西百身党构情。");
        return createProductBrandReq;
    }

    private UpdateProductBrandReq updateSuccessDTO() {
        UpdateProductBrandReq updateProductBrandReq = new UpdateProductBrandReq();
        updateProductBrandReq.setName("更新");
        updateProductBrandReq.setBannerUrl("http://npbrh.mo/ykxvututd");
        updateProductBrandReq.setSort(1);
        updateProductBrandReq.setStatus(UpdateProductBrandReq.StatusEnum.NUMBER_1);
        updateProductBrandReq.setDescription("品合从角石们声即电入法满大称许。导复响世过响它性认提说元及组位复运。米时毛见加今万地成你求厂也数广。放许员内达情院图今高只况动响方置件。变根平众线叫料务品当华住平。土九采团写行对西百身党构情。");
        return updateProductBrandReq;
    }
}
