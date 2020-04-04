package com.poplar.order.controller;

import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;
import com.poplar.order.domain.OrderItem;
import com.poplar.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 订单项信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:45:56
 */
@RestController
@RequestMapping("order/orderitem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderitem:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = orderItemService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderitem:info")
    public Result<OrderItem> info(@PathVariable("id") Long id){
		OrderItem orderItem = orderItemService.getById(id);

        return Result.success(orderItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderitem:save")
    public Result<Boolean> save(@RequestBody OrderItem orderItem){

        return Result.success(orderItemService.save(orderItem));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("order:orderitem:update")
    public Result<Boolean> update(@RequestBody OrderItem orderItem){

        return Result.success(orderItemService.updateById(orderItem));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderitem:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(orderItemService.removeByIds(Arrays.asList(ids)));
    }

}
