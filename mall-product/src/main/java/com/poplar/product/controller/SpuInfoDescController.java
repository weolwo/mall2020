package com.poplar.product.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poplar.product.domain.SpuInfoDesc;
import com.poplar.product.service.SpuInfoDescService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * spu信息介绍
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {
    @Autowired
    private SpuInfoDescService spuInfoDescService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuinfodesc:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoDescService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{spuId}")
    //@RequiresPermissions("product:spuinfodesc:info")
    public Result<SpuInfoDesc> info(@PathVariable("spuId") Long spuId){
		SpuInfoDesc spuInfoDesc = spuInfoDescService.getById(spuId);

        return Result.success(spuInfoDesc);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spuinfodesc:save")
    public Result<Boolean> save(@RequestBody SpuInfoDesc spuInfoDesc){

        return Result.success(spuInfoDescService.save(spuInfoDesc));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:spuinfodesc:update")
    public Result<Boolean> update(@RequestBody SpuInfoDesc spuInfoDesc){

        return Result.success(spuInfoDescService.updateById(spuInfoDesc));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spuinfodesc:delete")
    public Result<Boolean> delete(@RequestBody Long[] spuIds){

        return Result.success(spuInfoDescService.removeByIds(Arrays.asList(spuIds)));
    }

}
