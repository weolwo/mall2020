package com.poplar.member.feign;

import com.poplar.common.utils.Result;
import com.poplar.coupon.domain.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create BY poplar ON 2020/4/3
 * 这是一个申明书的远程调用
 */
@FeignClient("mall-coupon")
public interface CouponServiceFeign {
    //获取优惠券，测试openfeign
    @RequestMapping(value = "/coupon/coupon/couponList")
    Result<Coupon> getCouponList();
}
