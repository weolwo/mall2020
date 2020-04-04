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

import com.poplar.order.domain.RefundInfo;
import com.poplar.order.service.RefundInfoService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 退款信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:45:56
 */
@RestController
@RequestMapping("order/refundinfo")
public class RefundInfoController {
    @Autowired
    private RefundInfoService refundInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:refundinfo:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = refundInfoService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:refundinfo:info")
    public Result<RefundInfo> info(@PathVariable("id") Long id){
		RefundInfo refundInfo = refundInfoService.getById(id);

        return Result.success(refundInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:refundinfo:save")
    public Result<Boolean> save(@RequestBody RefundInfo refundInfo){

        return Result.success(refundInfoService.save(refundInfo));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("order:refundinfo:update")
    public Result<Boolean> update(@RequestBody RefundInfo refundInfo){

        return Result.success(refundInfoService.updateById(refundInfo));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:refundinfo:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(refundInfoService.removeByIds(Arrays.asList(ids)));
    }

}
