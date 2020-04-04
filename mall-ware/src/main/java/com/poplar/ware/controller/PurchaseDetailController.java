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

import com.poplar.ware.domain.PurchaseDetail;
import com.poplar.ware.service.PurchaseDetailService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:53:53
 */
@RestController
@RequestMapping("ware/purchasedetail")
public class PurchaseDetailController {
    @Autowired
    private PurchaseDetailService purchaseDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:purchasedetail:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseDetailService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:purchasedetail:info")
    public Result<PurchaseDetail> info(@PathVariable("id") Long id){
		PurchaseDetail purchaseDetail = purchaseDetailService.getById(id);

        return Result.success(purchaseDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:purchasedetail:save")
    public Result<Boolean> save(@RequestBody PurchaseDetail purchaseDetail){

        return Result.success(purchaseDetailService.save(purchaseDetail));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("ware:purchasedetail:update")
    public Result<Boolean> update(@RequestBody PurchaseDetail purchaseDetail){

        return Result.success(purchaseDetailService.updateById(purchaseDetail));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:purchasedetail:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(purchaseDetailService.removeByIds(Arrays.asList(ids)));
    }

}
