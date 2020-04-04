package com.poplar.order.controller;

import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;
import com.poplar.order.domain.Order;
import com.poplar.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 订单
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:45:56
 */
@RestController
@RequestMapping("order/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:order:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:order:info")
    public Result<Order> info(@PathVariable("id") Long id){
		Order order = orderService.getById(id);

        return Result.success(order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:order:save")
    public Result<Boolean> save(@RequestBody Order order){

        return Result.success(orderService.save(order));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("order:order:update")
    public Result<Boolean> update(@RequestBody Order order){

        return Result.success(orderService.updateById(order));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:order:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(orderService.removeByIds(Arrays.asList(ids)));
    }

}
