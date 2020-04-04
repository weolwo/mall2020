package com.poplar.product.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poplar.product.domain.SkuSaleAttrValue;
import com.poplar.product.service.SkuSaleAttrValueService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * sku销售属性&值
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/skusaleattrvalue")
public class SkuSaleAttrValueController {
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:skusaleattrvalue:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = skuSaleAttrValueService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:skusaleattrvalue:info")
    public Result<SkuSaleAttrValue> info(@PathVariable("id") Long id){
		SkuSaleAttrValue skuSaleAttrValue = skuSaleAttrValueService.getById(id);

        return Result.success(skuSaleAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:skusaleattrvalue:save")
    public Result<Boolean> save(@RequestBody SkuSaleAttrValue skuSaleAttrValue){

        return Result.success(skuSaleAttrValueService.save(skuSaleAttrValue));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:skusaleattrvalue:update")
    public Result<Boolean> update(@RequestBody SkuSaleAttrValue skuSaleAttrValue){

        return Result.success(skuSaleAttrValueService.updateById(skuSaleAttrValue));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:skusaleattrvalue:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(skuSaleAttrValueService.removeByIds(Arrays.asList(ids)));
    }

}
