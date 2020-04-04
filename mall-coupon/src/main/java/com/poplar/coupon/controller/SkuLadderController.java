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

import com.poplar.coupon.domain.SkuLadder;
import com.poplar.coupon.service.SkuLadderService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 商品阶梯价格
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/skuladder")
public class SkuLadderController {
    @Autowired
    private SkuLadderService skuLadderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:skuladder:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = skuLadderService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:skuladder:info")
    public Result<SkuLadder> info(@PathVariable("id") Long id){
		SkuLadder skuLadder = skuLadderService.getById(id);

        return Result.success(skuLadder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:skuladder:save")
    public Result<Boolean> save(@RequestBody SkuLadder skuLadder){

        return Result.success(skuLadderService.save(skuLadder));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:skuladder:update")
    public Result<Boolean> update(@RequestBody SkuLadder skuLadder){

        return Result.success(skuLadderService.updateById(skuLadder));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:skuladder:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(skuLadderService.removeByIds(Arrays.asList(ids)));
    }

}
