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

import com.poplar.coupon.domain.CouponSpuCategoryRelation;
import com.poplar.coupon.service.CouponSpuCategoryRelationService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 优惠券分类关联
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/couponspucategoryrelation")
public class CouponSpuCategoryRelationController {
    @Autowired
    private CouponSpuCategoryRelationService couponSpuCategoryRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:couponspucategoryrelation:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = couponSpuCategoryRelationService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:couponspucategoryrelation:info")
    public Result<CouponSpuCategoryRelation> info(@PathVariable("id") Long id){
		CouponSpuCategoryRelation couponSpuCategoryRelation = couponSpuCategoryRelationService.getById(id);

        return Result.success(couponSpuCategoryRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:couponspucategoryrelation:save")
    public Result<Boolean> save(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation){

        return Result.success(couponSpuCategoryRelationService.save(couponSpuCategoryRelation));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:couponspucategoryrelation:update")
    public Result<Boolean> update(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation){

        return Result.success(couponSpuCategoryRelationService.updateById(couponSpuCategoryRelation));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:couponspucategoryrelation:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(couponSpuCategoryRelationService.removeByIds(Arrays.asList(ids)));
    }

}
