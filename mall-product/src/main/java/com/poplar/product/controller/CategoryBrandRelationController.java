package com.poplar.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;
import com.poplar.product.domain.Brand;
import com.poplar.product.domain.Category;
import com.poplar.product.domain.CategoryBrandRelation;
import com.poplar.product.service.BrandService;
import com.poplar.product.service.CategoryBrandRelationService;
import com.poplar.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;


/**
 * 品牌分类关联
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取当前关联列表
     */
    @GetMapping("/catelog/list")
    public Result<List<CategoryBrandRelation>> catelogList(@RequestParam("brandId") Long brandId) {
        List<CategoryBrandRelation> data = categoryBrandRelationService.list(new QueryWrapper<CategoryBrandRelation>().eq("brand_id", brandId));
        return Result.success(data);
    }

    @RequestMapping("/list")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params) {
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return Result.success(page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:categorybrandrelation:info")
    public Result<CategoryBrandRelation> info(@PathVariable("id") Long id) {
        CategoryBrandRelation categoryBrandRelation = categoryBrandRelationService.getById(id);

        return Result.success(categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result<Boolean> save(@RequestBody CategoryBrandRelation categoryBrandRelation) {
        Long brandId = categoryBrandRelation.getBrandId();
        Brand brand = brandService.getById(brandId);
        categoryBrandRelation.setBrandName(brand.getName());
        Long catelogId = categoryBrandRelation.getCatelogId();
        Category category = categoryService.getById(catelogId);
        categoryBrandRelation.setCatelogName(category.getName());
        return Result.success(categoryBrandRelationService.save(categoryBrandRelation));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:categorybrandrelation:update")
    public Result<Boolean> update(@RequestBody CategoryBrandRelation categoryBrandRelation) {

        return Result.success(categoryBrandRelationService.updateById(categoryBrandRelation));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:categorybrandrelation:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids) {

        return Result.success(categoryBrandRelationService.removeByIds(Arrays.asList(ids)));
    }

}
