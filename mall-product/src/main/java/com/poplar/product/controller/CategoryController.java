package com.poplar.product.controller;

import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;
import com.poplar.product.domain.Category;
import com.poplar.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



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
     * 获取分类列表
     */
    @RequestMapping("/list/tree")
    public Result< List<Category>> getCategoryList(){
        List<Category> categoryList = categoryService.getCategoryList();
        return Result.success(categoryList);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:categorynfo")
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
    public Result<Boolean> update(@RequestBody Category category){

        return Result.success(categoryService.updateCategoryDetail(category));
    }

    /**
     * 删除
     * @RequestBody 请求必须为post
     */
    @RequestMapping("/delete")
    public Result<Integer> delete(@RequestBody Long[] catIds){

        //return Result.success(categoryService.removeByIds(Arrays.asList(catIds)));
        return Result.success(categoryService.removeMenuByIds(catIds));
    }

}
