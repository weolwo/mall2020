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

import com.poplar.product.domain.Category;
import com.poplar.product.service.CategoryService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 商品三级分类
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:category:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public Result<Category> info(@PathVariable("catId") Long catId){
		Category category = categoryService.getById(catId);

        return Result.success(category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public Result<Boolean> save(@RequestBody Category category){

        return Result.success(categoryService.save(category));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:category:update")
    public Result<Boolean> update(@RequestBody Category category){

        return Result.success(categoryService.updateById(category));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public Result<Boolean> delete(@RequestBody Long[] catIds){

        return Result.success(categoryService.removeByIds(Arrays.asList(catIds)));
    }

}
