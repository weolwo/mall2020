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

import com.poplar.product.domain.SpuInfo;
import com.poplar.product.service.SpuInfoService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * spu信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/spuinfo")
public class SpuInfoController {
    @Autowired
    private SpuInfoService spuInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuinfo:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:spuinfo:info")
    public Result<SpuInfo> info(@PathVariable("id") Long id){
		SpuInfo spuInfo = spuInfoService.getById(id);

        return Result.success(spuInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spuinfo:save")
    public Result<Boolean> save(@RequestBody SpuInfo spuInfo){

        return Result.success(spuInfoService.save(spuInfo));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:spuinfo:update")
    public Result<Boolean> update(@RequestBody SpuInfo spuInfo){

        return Result.success(spuInfoService.updateById(spuInfo));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spuinfo:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(spuInfoService.removeByIds(Arrays.asList(ids)));
    }

}
