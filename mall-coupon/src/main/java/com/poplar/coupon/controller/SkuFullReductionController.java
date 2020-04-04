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

import com.poplar.coupon.domain.SkuFullReduction;
import com.poplar.coupon.service.SkuFullReductionService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 商品满减信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/skufullreduction")
public class SkuFullReductionController {
    @Autowired
    private SkuFullReductionService skuFullReductionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:skufullreduction:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = skuFullReductionService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:skufullreduction:info")
    public Result<SkuFullReduction> info(@PathVariable("id") Long id){
		SkuFullReduction skuFullReduction = skuFullReductionService.getById(id);

        return Result.success(skuFullReduction);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:skufullreduction:save")
    public Result<Boolean> save(@RequestBody SkuFullReduction skuFullReduction){

        return Result.success(skuFullReductionService.save(skuFullReduction));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:skufullreduction:update")
    public Result<Boolean> update(@RequestBody SkuFullReduction skuFullReduction){

        return Result.success(skuFullReductionService.updateById(skuFullReduction));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:skufullreduction:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(skuFullReductionService.removeByIds(Arrays.asList(ids)));
    }

}
