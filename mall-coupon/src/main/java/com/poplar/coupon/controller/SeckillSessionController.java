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

import com.poplar.coupon.domain.SeckillSession;
import com.poplar.coupon.service.SeckillSessionService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 秒杀活动场次
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/seckillsession")
public class SeckillSessionController {
    @Autowired
    private SeckillSessionService seckillSessionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:seckillsession:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSessionService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:seckillsession:info")
    public Result<SeckillSession> info(@PathVariable("id") Long id){
		SeckillSession seckillSession = seckillSessionService.getById(id);

        return Result.success(seckillSession);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:seckillsession:save")
    public Result<Boolean> save(@RequestBody SeckillSession seckillSession){

        return Result.success(seckillSessionService.save(seckillSession));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:seckillsession:update")
    public Result<Boolean> update(@RequestBody SeckillSession seckillSession){

        return Result.success(seckillSessionService.updateById(seckillSession));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:seckillsession:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(seckillSessionService.removeByIds(Arrays.asList(ids)));
    }

}
