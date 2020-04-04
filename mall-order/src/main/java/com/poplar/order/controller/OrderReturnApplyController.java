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

import com.poplar.order.domain.OrderReturnApply;
import com.poplar.order.service.OrderReturnApplyService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 订单退货申请
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:45:56
 */
@RestController
@RequestMapping("order/orderreturnapply")
public class OrderReturnApplyController {
    @Autowired
    private OrderReturnApplyService orderReturnApplyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderreturnapply:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = orderReturnApplyService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderreturnapply:info")
    public Result<OrderReturnApply> info(@PathVariable("id") Long id){
		OrderReturnApply orderReturnApply = orderReturnApplyService.getById(id);

        return Result.success(orderReturnApply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderreturnapply:save")
    public Result<Boolean> save(@RequestBody OrderReturnApply orderReturnApply){

        return Result.success(orderReturnApplyService.save(orderReturnApply));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("order:orderreturnapply:update")
    public Result<Boolean> update(@RequestBody OrderReturnApply orderReturnApply){

        return Result.success(orderReturnApplyService.updateById(orderReturnApply));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderreturnapply:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(orderReturnApplyService.removeByIds(Arrays.asList(ids)));
    }

}
