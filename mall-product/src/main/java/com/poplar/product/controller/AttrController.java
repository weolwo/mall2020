package com.poplar.product.controller;

import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;
import com.poplar.product.domain.Attr;
import com.poplar.product.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 商品属性
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return Result.success(page);
    }
    @RequestMapping("/base/list/{catId}")
    //@RequiresPermissions("product:attr:list")
    public Result<PageUtils> baseList(@RequestParam Map<String, Object> params,@PathVariable("catId")Long catId){
        PageUtils page = attrService.queryDetail(params,catId);

        return Result.success(page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public Result<Attr> info(@PathVariable("attrId") Long attrId){
		Attr attr = attrService.getById(attrId);

        return Result.success(attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public Result<Boolean> save(@RequestBody Attr attr){

        return Result.success(attrService.save(attr));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:attr:update")
    public Result<Boolean> update(@RequestBody Attr attr){

        return Result.success(attrService.updateById(attr));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public Result<Boolean> delete(@RequestBody Long[] attrIds){

        return Result.success(attrService.removeByIds(Arrays.asList(attrIds)));
    }

}
