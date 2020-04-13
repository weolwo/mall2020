package com.poplar.product.controller;

import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;
import com.poplar.product.domain.AttrGroup;
import com.poplar.product.service.AttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;


/**
 * 属性分组
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params, @PathVariable("catelogId") Long catelogId) {
        PageUtils page = attrGroupService.queryPage(params, catelogId);
        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public Result<AttrGroup> info(@PathVariable("attrGroupId") Long attrGroupId) {
        AttrGroup attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        //根据catelogId查找所有的层级数组[1,23,33]
        Long[] path = attrGroupService.queryCatelogPath(catelogId);
        attrGroup.setCatelogPath(path);
        return Result.success(attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public Result<Boolean> save(@RequestBody AttrGroup attrGroup) {

        return Result.success(attrGroupService.save(attrGroup));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:attrgroup:update")
    public Result<Boolean> update(@RequestBody AttrGroup attrGroup) {

        return Result.success(attrGroupService.updateById(attrGroup));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public Result<Boolean> delete(@RequestBody Long[] attrGroupIds) {

        return Result.success(attrGroupService.removeByIds(Arrays.asList(attrGroupIds)));
    }

}
