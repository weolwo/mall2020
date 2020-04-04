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

import com.poplar.product.domain.ProductAttrValue;
import com.poplar.product.service.ProductAttrValueService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * spu属性值
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/productattrvalue")
public class ProductAttrValueController {
    @Autowired
    private ProductAttrValueService productAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:productattrvalue:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = productAttrValueService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:productattrvalue:info")
    public Result<ProductAttrValue> info(@PathVariable("id") Long id){
		ProductAttrValue productAttrValue = productAttrValueService.getById(id);

        return Result.success(productAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:productattrvalue:save")
    public Result<Boolean> save(@RequestBody ProductAttrValue productAttrValue){

        return Result.success(productAttrValueService.save(productAttrValue));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:productattrvalue:update")
    public Result<Boolean> update(@RequestBody ProductAttrValue productAttrValue){

        return Result.success(productAttrValueService.updateById(productAttrValue));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:productattrvalue:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(productAttrValueService.removeByIds(Arrays.asList(ids)));
    }

}
