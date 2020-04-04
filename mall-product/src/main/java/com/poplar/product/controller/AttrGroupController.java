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

import com.poplar.product.domain.AttrGroup;
import com.poplar.product.service.AttrGroupService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



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
    @RequestMapping("/list")
    //@RequiresPermissions("product:attrgroup:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = attrGroupService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public Result<AttrGroup> info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroup attrGroup = attrGroupService.getById(attrGroupId);

        return Result.success(attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public Result<Boolean> save(@RequestBody AttrGroup attrGroup){

        return Result.success(attrGroupService.save(attrGroup));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:attrgroup:update")
    public Result<Boolean> update(@RequestBody AttrGroup attrGroup){

        return Result.success(attrGroupService.updateById(attrGroup));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public Result<Boolean> delete(@RequestBody Long[] attrGroupIds){

        return Result.success(attrGroupService.removeByIds(Arrays.asList(attrGroupIds)));
    }

}
