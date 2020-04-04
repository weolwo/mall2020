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

import com.poplar.coupon.domain.MemberPrice;
import com.poplar.coupon.service.MemberPriceService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 商品会员价格
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/memberprice")
public class MemberPriceController {
    @Autowired
    private MemberPriceService memberPriceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:memberprice:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = memberPriceService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:memberprice:info")
    public Result<MemberPrice> info(@PathVariable("id") Long id){
		MemberPrice memberPrice = memberPriceService.getById(id);

        return Result.success(memberPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:memberprice:save")
    public Result<Boolean> save(@RequestBody MemberPrice memberPrice){

        return Result.success(memberPriceService.save(memberPrice));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:memberprice:update")
    public Result<Boolean> update(@RequestBody MemberPrice memberPrice){

        return Result.success(memberPriceService.updateById(memberPrice));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:memberprice:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(memberPriceService.removeByIds(Arrays.asList(ids)));
    }

}
