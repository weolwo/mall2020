package com.poplar.product.controller;

import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;
import com.poplar.product.domain.Brand;
import com.poplar.product.service.BrandService;
import com.poplar.valid.AddGroup;
import com.poplar.valid.UpdateGroup;
import com.poplar.valid.UpdateStatusGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;


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
    public Result<PageUtils> list(@RequestParam Map<String, Object> params) {
        PageUtils page = brandService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public Result<Brand> info(@PathVariable("brandId") Long brandId) {
        Brand brand = brandService.getById(brandId);

        return Result.success(brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public Result<Object> save(@RequestBody @Validated(AddGroup.class) Brand brand) {
        return Result.success(brandService.save(brand));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:brand:update")
    public Result<Boolean> update(@RequestBody @Validated(UpdateGroup.class) Brand brand) {

        return Result.success(brandService.updateById(brand));
    }

    /**
     * 修改状态
     */
    @RequestMapping("/update/status")
    public Result<Boolean> updateStatus(@RequestBody @Validated(UpdateStatusGroup.class) Brand brand) {

        return Result.success(brandService.updateById(brand));
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public Result<Boolean> delete(@RequestBody Long[] brandIds) {

        return Result.success(brandService.removeByIds(Arrays.asList(brandIds)));
    }

}
