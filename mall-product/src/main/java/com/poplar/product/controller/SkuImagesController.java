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

import com.poplar.product.domain.SkuImages;
import com.poplar.product.service.SkuImagesService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * sku图片
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/skuimages")
public class SkuImagesController {
    @Autowired
    private SkuImagesService skuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:skuimages:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = skuImagesService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:skuimages:info")
    public Result<SkuImages> info(@PathVariable("id") Long id){
		SkuImages skuImages = skuImagesService.getById(id);

        return Result.success(skuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:skuimages:save")
    public Result<Boolean> save(@RequestBody SkuImages skuImages){

        return Result.success(skuImagesService.save(skuImages));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:skuimages:update")
    public Result<Boolean> update(@RequestBody SkuImages skuImages){

        return Result.success(skuImagesService.updateById(skuImages));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:skuimages:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(skuImagesService.removeByIds(Arrays.asList(ids)));
    }

}
