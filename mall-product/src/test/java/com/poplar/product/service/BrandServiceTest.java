package com.poplar.product.service;

import com.poplar.product.domain.Brand;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create BY poplar ON 2020/4/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class BrandServiceTest {

    @Autowired
    BrandService brandService;

    @Test
    void queryPage() {
        brandService.list().forEach(System.out::println);

    }
    @Test
    void save() {
        Brand brand = new Brand();
        brand.setName("华为");
        brand.setLogo("菊花");
        brandService.save(brand);
    }
    @Test
    void update() {
        Brand brand = new Brand();
        brand.setBrandId(1L);
        brand.setDescript("华为中国");
        brandService.updateById(brand);
    }
}