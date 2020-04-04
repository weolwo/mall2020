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

import com.poplar.product.domain.Brand;
import com.poplar.product.service.BrandService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 品牌
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public Result<Brand> info(@PathVariable("brandId") Long brandId){
		Brand brand = brandService.getById(brandId);

        return Result.success(brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public Result<Boolean> save(@RequestBody Brand brand){

        return Result.success(brandService.save(brand));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:brand:update")
    public Result<Boolean> update(@RequestBody Brand brand){

        return Result.success(brandService.updateById(brand));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public Result<Boolean> delete(@RequestBody Long[] brandIds){

        return Result.success(brandService.removeByIds(Arrays.asList(brandIds)));
    }

}
