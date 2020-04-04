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

import com.poplar.ware.domain.WareOrderTaskDetail;
import com.poplar.ware.service.WareOrderTaskDetailService;
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
@RequestMapping("ware/wareordertaskdetail")
public class WareOrderTaskDetailController {
    @Autowired
    private WareOrderTaskDetailService wareOrderTaskDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:wareordertaskdetail:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = wareOrderTaskDetailService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:wareordertaskdetail:info")
    public Result<WareOrderTaskDetail> info(@PathVariable("id") Long id){
		WareOrderTaskDetail wareOrderTaskDetail = wareOrderTaskDetailService.getById(id);

        return Result.success(wareOrderTaskDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:wareordertaskdetail:save")
    public Result<Boolean> save(@RequestBody WareOrderTaskDetail wareOrderTaskDetail){

        return Result.success(wareOrderTaskDetailService.save(wareOrderTaskDetail));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("ware:wareordertaskdetail:update")
    public Result<Boolean> update(@RequestBody WareOrderTaskDetail wareOrderTaskDetail){

        return Result.success(wareOrderTaskDetailService.updateById(wareOrderTaskDetail));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:wareordertaskdetail:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(wareOrderTaskDetailService.removeByIds(Arrays.asList(ids)));
    }

}
