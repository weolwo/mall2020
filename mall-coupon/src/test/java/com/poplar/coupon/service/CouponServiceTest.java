package com.poplar.coupon.service;

import com.poplar.coupon.domain.Coupon;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Create BY poplar ON 2020/4/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class CouponServiceTest {

    @Autowired
    private CouponService couponService;

    @Test
    void queryPage() {
        couponService.list().forEach(System.out::println);
    }

    @Test
    void save() {
        Coupon coupon = new Coupon();
        coupon.setCouponName("5元优惠券");
        coupon.setEndTime(new Date());
        couponService.save(coupon);
    }
}