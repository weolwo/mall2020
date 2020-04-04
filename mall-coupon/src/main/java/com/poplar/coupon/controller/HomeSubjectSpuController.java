package com.poplar.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poplar.coupon.domain.HomeSubjectSpu;
import com.poplar.coupon.service.HomeSubjectSpuService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 专题商品
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/homesubjectspu")
public class HomeSubjectSpuController {
    @Autowired
    private HomeSubjectSpuService homeSubjectSpuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:homesubjectspu:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = homeSubjectSpuService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:homesubjectspu:info")
    public Result<HomeSubjectSpu> info(@PathVariable("id") Long id){
		HomeSubjectSpu homeSubjectSpu = homeSubjectSpuService.getById(id);

        return Result.success(homeSubjectSpu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:homesubjectspu:save")
    public Result<Boolean> save(@RequestBody HomeSubjectSpu homeSubjectSpu){

        return Result.success(homeSubjectSpuService.save(homeSubjectSpu));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:homesubjectspu:update")
    public Result<Boolean> update(@RequestBody HomeSubjectSpu homeSubjectSpu){

        return Result.success(homeSubjectSpuService.updateById(homeSubjectSpu));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:homesubjectspu:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(homeSubjectSpuService.removeByIds(Arrays.asList(ids)));
    }

}
