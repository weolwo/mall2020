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

import com.poplar.ware.domain.WareSku;
import com.poplar.ware.service.WareSkuService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 商品库存
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:53:53
 */
@RestController
@RequestMapping("ware/waresku")
public class WareSkuController {
    @Autowired
    private WareSkuService wareSkuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:waresku:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = wareSkuService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:waresku:info")
    public Result<WareSku> info(@PathVariable("id") Long id){
		WareSku wareSku = wareSkuService.getById(id);

        return Result.success(wareSku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:waresku:save")
    public Result<Boolean> save(@RequestBody WareSku wareSku){

        return Result.success(wareSkuService.save(wareSku));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("ware:waresku:update")
    public Result<Boolean> update(@RequestBody WareSku wareSku){

        return Result.success(wareSkuService.updateById(wareSku));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:waresku:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(wareSkuService.removeByIds(Arrays.asList(ids)));
    }

}
