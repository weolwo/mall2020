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

import com.poplar.product.domain.AttrAttrgroupRelation;
import com.poplar.product.service.AttrAttrgroupRelationService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 属性&属性分组关联
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attrattrgrouprelation:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = attrAttrgroupRelationService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:attrattrgrouprelation:info")
    public Result<AttrAttrgroupRelation> info(@PathVariable("id") Long id){
		AttrAttrgroupRelation attrAttrgroupRelation = attrAttrgroupRelationService.getById(id);

        return Result.success(attrAttrgroupRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrattrgrouprelation:save")
    public Result<Boolean> save(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation){

        return Result.success(attrAttrgroupRelationService.save(attrAttrgroupRelation));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:attrattrgrouprelation:update")
    public Result<Boolean> update(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation){

        return Result.success(attrAttrgroupRelationService.updateById(attrAttrgroupRelation));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrattrgrouprelation:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(attrAttrgroupRelationService.removeByIds(Arrays.asList(ids)));
    }

}
