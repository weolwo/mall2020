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

import com.poplar.coupon.domain.CouponSpuRelation;
import com.poplar.coupon.service.CouponSpuRelationService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 优惠券与产品关联
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/couponspurelation")
public class CouponSpuRelationController {
    @Autowired
    private CouponSpuRelationService couponSpuRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:couponspurelation:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = couponSpuRelationService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:couponspurelation:info")
    public Result<CouponSpuRelation> info(@PathVariable("id") Long id){
		CouponSpuRelation couponSpuRelation = couponSpuRelationService.getById(id);

        return Result.success(couponSpuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:couponspurelation:save")
    public Result<Boolean> save(@RequestBody CouponSpuRelation couponSpuRelation){

        return Result.success(couponSpuRelationService.save(couponSpuRelation));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:couponspurelation:update")
    public Result<Boolean> update(@RequestBody CouponSpuRelation couponSpuRelation){

        return Result.success(couponSpuRelationService.updateById(couponSpuRelation));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:couponspurelation:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(couponSpuRelationService.removeByIds(Arrays.asList(ids)));
    }

}
