package com.poplar.order.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poplar.order.domain.OrderOperateHistory;
import com.poplar.order.service.OrderOperateHistoryService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 订单操作历史记录
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:45:56
 */
@RestController
@RequestMapping("order/orderoperatehistory")
public class OrderOperateHistoryController {
    @Autowired
    private OrderOperateHistoryService orderOperateHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderoperatehistory:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = orderOperateHistoryService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderoperatehistory:info")
    public Result<OrderOperateHistory> info(@PathVariable("id") Long id){
		OrderOperateHistory orderOperateHistory = orderOperateHistoryService.getById(id);

        return Result.success(orderOperateHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderoperatehistory:save")
    public Result<Boolean> save(@RequestBody OrderOperateHistory orderOperateHistory){

        return Result.success(orderOperateHistoryService.save(orderOperateHistory));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("order:orderoperatehistory:update")
    public Result<Boolean> update(@RequestBody OrderOperateHistory orderOperateHistory){

        return Result.success(orderOperateHistoryService.updateById(orderOperateHistory));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderoperatehistory:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(orderOperateHistoryService.removeByIds(Arrays.asList(ids)));
    }

}
