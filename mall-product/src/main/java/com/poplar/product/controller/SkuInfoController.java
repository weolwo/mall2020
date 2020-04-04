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

import com.poplar.product.domain.SkuInfo;
import com.poplar.product.service.SkuInfoService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * sku信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/skuinfo")
public class SkuInfoController {
    @Autowired
    private SkuInfoService skuInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:skuinfo:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = skuInfoService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{skuId}")
    //@RequiresPermissions("product:skuinfo:info")
    public Result<SkuInfo> info(@PathVariable("skuId") Long skuId){
		SkuInfo skuInfo = skuInfoService.getById(skuId);

        return Result.success(skuInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:skuinfo:save")
    public Result<Boolean> save(@RequestBody SkuInfo skuInfo){

        return Result.success(skuInfoService.save(skuInfo));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:skuinfo:update")
    public Result<Boolean> update(@RequestBody SkuInfo skuInfo){

        return Result.success(skuInfoService.updateById(skuInfo));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:skuinfo:delete")
    public Result<Boolean> delete(@RequestBody Long[] skuIds){

        return Result.success(skuInfoService.removeByIds(Arrays.asList(skuIds)));
    }

}
