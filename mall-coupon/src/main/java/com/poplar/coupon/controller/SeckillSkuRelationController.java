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

import com.poplar.coupon.domain.SeckillSkuRelation;
import com.poplar.coupon.service.SeckillSkuRelationService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 秒杀活动商品关联
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/seckillskurelation")
public class SeckillSkuRelationController {
    @Autowired
    private SeckillSkuRelationService seckillSkuRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:seckillskurelation:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSkuRelationService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:seckillskurelation:info")
    public Result<SeckillSkuRelation> info(@PathVariable("id") Long id){
		SeckillSkuRelation seckillSkuRelation = seckillSkuRelationService.getById(id);

        return Result.success(seckillSkuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:seckillskurelation:save")
    public Result<Boolean> save(@RequestBody SeckillSkuRelation seckillSkuRelation){

        return Result.success(seckillSkuRelationService.save(seckillSkuRelation));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:seckillskurelation:update")
    public Result<Boolean> update(@RequestBody SeckillSkuRelation seckillSkuRelation){

        return Result.success(seckillSkuRelationService.updateById(seckillSkuRelation));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:seckillskurelation:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(seckillSkuRelationService.removeByIds(Arrays.asList(ids)));
    }

}
