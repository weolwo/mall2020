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

import com.poplar.order.domain.OrderSetting;
import com.poplar.order.service.OrderSettingService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 订单配置信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:45:56
 */
@RestController
@RequestMapping("order/ordersetting")
public class OrderSettingController {
    @Autowired
    private OrderSettingService orderSettingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:ordersetting:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = orderSettingService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:ordersetting:info")
    public Result<OrderSetting> info(@PathVariable("id") Long id){
		OrderSetting orderSetting = orderSettingService.getById(id);

        return Result.success(orderSetting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:ordersetting:save")
    public Result<Boolean> save(@RequestBody OrderSetting orderSetting){

        return Result.success(orderSettingService.save(orderSetting));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("order:ordersetting:update")
    public Result<Boolean> update(@RequestBody OrderSetting orderSetting){

        return Result.success(orderSettingService.updateById(orderSetting));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:ordersetting:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(orderSettingService.removeByIds(Arrays.asList(ids)));
    }

}
