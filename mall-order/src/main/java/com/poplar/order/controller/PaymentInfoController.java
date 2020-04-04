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

import com.poplar.order.domain.PaymentInfo;
import com.poplar.order.service.PaymentInfoService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 支付信息表
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:45:56
 */
@RestController
@RequestMapping("order/paymentinfo")
public class PaymentInfoController {
    @Autowired
    private PaymentInfoService paymentInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:paymentinfo:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = paymentInfoService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:paymentinfo:info")
    public Result<PaymentInfo> info(@PathVariable("id") Long id){
		PaymentInfo paymentInfo = paymentInfoService.getById(id);

        return Result.success(paymentInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:paymentinfo:save")
    public Result<Boolean> save(@RequestBody PaymentInfo paymentInfo){

        return Result.success(paymentInfoService.save(paymentInfo));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("order:paymentinfo:update")
    public Result<Boolean> update(@RequestBody PaymentInfo paymentInfo){

        return Result.success(paymentInfoService.updateById(paymentInfo));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:paymentinfo:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(paymentInfoService.removeByIds(Arrays.asList(ids)));
    }

}
