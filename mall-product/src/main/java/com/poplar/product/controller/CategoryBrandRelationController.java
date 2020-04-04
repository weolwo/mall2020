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

import com.poplar.product.domain.CategoryBrandRelation;
import com.poplar.product.service.CategoryBrandRelationService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



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

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:categorybrandrelation:info")
    public Result<CategoryBrandRelation> info(@PathVariable("id") Long id){
		CategoryBrandRelation categoryBrandRelation = categoryBrandRelationService.getById(id);

        return Result.success(categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:categorybrandrelation:save")
    public Result<Boolean> save(@RequestBody CategoryBrandRelation categoryBrandRelation){

        return Result.success(categoryBrandRelationService.save(categoryBrandRelation));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:categorybrandrelation:update")
    public Result<Boolean> update(@RequestBody CategoryBrandRelation categoryBrandRelation){

        return Result.success(categoryBrandRelationService.updateById(categoryBrandRelation));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:categorybrandrelation:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(categoryBrandRelationService.removeByIds(Arrays.asList(ids)));
    }

}
