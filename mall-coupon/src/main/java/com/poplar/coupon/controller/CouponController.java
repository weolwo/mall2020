package com.poplar.coupon.controller;

import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;
import com.poplar.coupon.domain.Coupon;
import com.poplar.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 优惠券信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @RequestMapping("/couponList")
    public Result<Coupon> getCouponList(){
        Coupon coupon = new Coupon();
        coupon.setNum(1);
        coupon.setCouponName("满100减10");
        coupon.setEndTime(new Date());
        return Result.success(coupon);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:coupon:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public Result<Coupon> info(@PathVariable("id") Long id){
		Coupon coupon = couponService.getById(id);

        return Result.success(coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public Result<Boolean> save(@RequestBody Coupon coupon){

        return Result.success(couponService.save(coupon));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:coupon:update")
    public Result<Boolean> update(@RequestBody Coupon coupon){

        return Result.success(couponService.updateById(coupon));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(couponService.removeByIds(Arrays.asList(ids)));
    }

}
