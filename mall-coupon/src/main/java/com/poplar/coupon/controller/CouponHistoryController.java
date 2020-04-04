package com.poplar.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poplar.coupon.domain.CouponHistory;
import com.poplar.coupon.service.CouponHistoryService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 优惠券领取历史记录
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/couponhistory")
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService couponHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:couponhistory:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = couponHistoryService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:couponhistory:info")
    public Result<CouponHistory> info(@PathVariable("id") Long id){
		CouponHistory couponHistory = couponHistoryService.getById(id);

        return Result.success(couponHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:couponhistory:save")
    public Result<Boolean> save(@RequestBody CouponHistory couponHistory){

        return Result.success(couponHistoryService.save(couponHistory));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:couponhistory:update")
    public Result<Boolean> update(@RequestBody CouponHistory couponHistory){

        return Result.success(couponHistoryService.updateById(couponHistory));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:couponhistory:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(couponHistoryService.removeByIds(Arrays.asList(ids)));
    }

}
