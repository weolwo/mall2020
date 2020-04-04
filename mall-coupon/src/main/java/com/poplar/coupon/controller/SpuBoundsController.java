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

import com.poplar.coupon.domain.SpuBounds;
import com.poplar.coupon.service.SpuBoundsService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 商品spu积分设置
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/spubounds")
public class SpuBoundsController {
    @Autowired
    private SpuBoundsService spuBoundsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:spubounds:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = spuBoundsService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:spubounds:info")
    public Result<SpuBounds> info(@PathVariable("id") Long id){
		SpuBounds spuBounds = spuBoundsService.getById(id);

        return Result.success(spuBounds);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:spubounds:save")
    public Result<Boolean> save(@RequestBody SpuBounds spuBounds){

        return Result.success(spuBoundsService.save(spuBounds));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:spubounds:update")
    public Result<Boolean> update(@RequestBody SpuBounds spuBounds){

        return Result.success(spuBoundsService.updateById(spuBounds));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:spubounds:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(spuBoundsService.removeByIds(Arrays.asList(ids)));
    }

}
