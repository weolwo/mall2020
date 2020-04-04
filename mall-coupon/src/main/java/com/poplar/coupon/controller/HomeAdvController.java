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

import com.poplar.coupon.domain.HomeAdv;
import com.poplar.coupon.service.HomeAdvService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 首页轮播广告
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/homeadv")
public class HomeAdvController {
    @Autowired
    private HomeAdvService homeAdvService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:homeadv:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = homeAdvService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:homeadv:info")
    public Result<HomeAdv> info(@PathVariable("id") Long id){
		HomeAdv homeAdv = homeAdvService.getById(id);

        return Result.success(homeAdv);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:homeadv:save")
    public Result<Boolean> save(@RequestBody HomeAdv homeAdv){

        return Result.success(homeAdvService.save(homeAdv));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:homeadv:update")
    public Result<Boolean> update(@RequestBody HomeAdv homeAdv){

        return Result.success(homeAdvService.updateById(homeAdv));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:homeadv:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(homeAdvService.removeByIds(Arrays.asList(ids)));
    }

}
