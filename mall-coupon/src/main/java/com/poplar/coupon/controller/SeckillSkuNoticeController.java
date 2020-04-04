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

import com.poplar.coupon.domain.SeckillSkuNotice;
import com.poplar.coupon.service.SeckillSkuNoticeService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 秒杀商品通知订阅
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/seckillskunotice")
public class SeckillSkuNoticeController {
    @Autowired
    private SeckillSkuNoticeService seckillSkuNoticeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:seckillskunotice:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSkuNoticeService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:seckillskunotice:info")
    public Result<SeckillSkuNotice> info(@PathVariable("id") Long id){
		SeckillSkuNotice seckillSkuNotice = seckillSkuNoticeService.getById(id);

        return Result.success(seckillSkuNotice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:seckillskunotice:save")
    public Result<Boolean> save(@RequestBody SeckillSkuNotice seckillSkuNotice){

        return Result.success(seckillSkuNoticeService.save(seckillSkuNotice));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:seckillskunotice:update")
    public Result<Boolean> update(@RequestBody SeckillSkuNotice seckillSkuNotice){

        return Result.success(seckillSkuNoticeService.updateById(seckillSkuNotice));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:seckillskunotice:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(seckillSkuNoticeService.removeByIds(Arrays.asList(ids)));
    }

}
