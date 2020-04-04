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

import com.poplar.coupon.domain.SeckillPromotion;
import com.poplar.coupon.service.SeckillPromotionService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 秒杀活动
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/seckillpromotion")
public class SeckillPromotionController {
    @Autowired
    private SeckillPromotionService seckillPromotionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:seckillpromotion:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillPromotionService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:seckillpromotion:info")
    public Result<SeckillPromotion> info(@PathVariable("id") Long id){
		SeckillPromotion seckillPromotion = seckillPromotionService.getById(id);

        return Result.success(seckillPromotion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:seckillpromotion:save")
    public Result<Boolean> save(@RequestBody SeckillPromotion seckillPromotion){

        return Result.success(seckillPromotionService.save(seckillPromotion));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:seckillpromotion:update")
    public Result<Boolean> update(@RequestBody SeckillPromotion seckillPromotion){

        return Result.success(seckillPromotionService.updateById(seckillPromotion));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:seckillpromotion:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(seckillPromotionService.removeByIds(Arrays.asList(ids)));
    }

}
