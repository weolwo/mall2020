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

import com.poplar.ware.domain.Purchase;
import com.poplar.ware.service.PurchaseService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 采购信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:53:53
 */
@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:purchase:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:purchase:info")
    public Result<Purchase> info(@PathVariable("id") Long id){
		Purchase purchase = purchaseService.getById(id);

        return Result.success(purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:purchase:save")
    public Result<Boolean> save(@RequestBody Purchase purchase){

        return Result.success(purchaseService.save(purchase));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("ware:purchase:update")
    public Result<Boolean> update(@RequestBody Purchase purchase){

        return Result.success(purchaseService.updateById(purchase));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:purchase:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(purchaseService.removeByIds(Arrays.asList(ids)));
    }

}
