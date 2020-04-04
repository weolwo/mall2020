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

import com.poplar.ware.domain.WareOrderTask;
import com.poplar.ware.service.WareOrderTaskService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 库存工作单
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:53:53
 */
@RestController
@RequestMapping("ware/wareordertask")
public class WareOrderTaskController {
    @Autowired
    private WareOrderTaskService wareOrderTaskService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:wareordertask:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = wareOrderTaskService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:wareordertask:info")
    public Result<WareOrderTask> info(@PathVariable("id") Long id){
		WareOrderTask wareOrderTask = wareOrderTaskService.getById(id);

        return Result.success(wareOrderTask);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:wareordertask:save")
    public Result<Boolean> save(@RequestBody WareOrderTask wareOrderTask){

        return Result.success(wareOrderTaskService.save(wareOrderTask));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("ware:wareordertask:update")
    public Result<Boolean> update(@RequestBody WareOrderTask wareOrderTask){

        return Result.success(wareOrderTaskService.updateById(wareOrderTask));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:wareordertask:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(wareOrderTaskService.removeByIds(Arrays.asList(ids)));
    }

}
