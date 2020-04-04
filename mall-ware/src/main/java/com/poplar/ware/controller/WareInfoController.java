package com.poplar.ware.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poplar.ware.domain.WareInfo;
import com.poplar.ware.service.WareInfoService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 仓库信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:53:53
 */
@RestController
@RequestMapping("ware/wareinfo")
public class WareInfoController {
    @Autowired
    private WareInfoService wareInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:wareinfo:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = wareInfoService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:wareinfo:info")
    public Result<WareInfo> info(@PathVariable("id") Long id){
		WareInfo wareInfo = wareInfoService.getById(id);

        return Result.success(wareInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:wareinfo:save")
    public Result<Boolean> save(@RequestBody WareInfo wareInfo){

        return Result.success(wareInfoService.save(wareInfo));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("ware:wareinfo:update")
    public Result<Boolean> update(@RequestBody WareInfo wareInfo){

        return Result.success(wareInfoService.updateById(wareInfo));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:wareinfo:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(wareInfoService.removeByIds(Arrays.asList(ids)));
    }

}
