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

import com.poplar.product.domain.SpuImages;
import com.poplar.product.service.SpuImagesService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * spu图片
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/spuimages")
public class SpuImagesController {
    @Autowired
    private SpuImagesService spuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuimages:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = spuImagesService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:spuimages:info")
    public Result<SpuImages> info(@PathVariable("id") Long id){
		SpuImages spuImages = spuImagesService.getById(id);

        return Result.success(spuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spuimages:save")
    public Result<Boolean> save(@RequestBody SpuImages spuImages){

        return Result.success(spuImagesService.save(spuImages));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:spuimages:update")
    public Result<Boolean> update(@RequestBody SpuImages spuImages){

        return Result.success(spuImagesService.updateById(spuImages));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spuimages:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(spuImagesService.removeByIds(Arrays.asList(ids)));
    }

}
