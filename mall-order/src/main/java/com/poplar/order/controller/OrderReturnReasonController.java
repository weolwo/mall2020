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

import com.poplar.order.domain.OrderReturnReason;
import com.poplar.order.service.OrderReturnReasonService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 退货原因
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:45:56
 */
@RestController
@RequestMapping("order/orderreturnreason")
public class OrderReturnReasonController {
    @Autowired
    private OrderReturnReasonService orderReturnReasonService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderreturnreason:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = orderReturnReasonService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderreturnreason:info")
    public Result<OrderReturnReason> info(@PathVariable("id") Long id){
		OrderReturnReason orderReturnReason = orderReturnReasonService.getById(id);

        return Result.success(orderReturnReason);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderreturnreason:save")
    public Result<Boolean> save(@RequestBody OrderReturnReason orderReturnReason){

        return Result.success(orderReturnReasonService.save(orderReturnReason));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("order:orderreturnreason:update")
    public Result<Boolean> update(@RequestBody OrderReturnReason orderReturnReason){

        return Result.success(orderReturnReasonService.updateById(orderReturnReason));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderreturnreason:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(orderReturnReasonService.removeByIds(Arrays.asList(ids)));
    }

}
