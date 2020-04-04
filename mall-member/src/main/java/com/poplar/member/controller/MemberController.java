package com.poplar.member.controller;

import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;
import com.poplar.coupon.domain.Coupon;
import com.poplar.member.domain.Member;
import com.poplar.member.feign.CouponServiceFeign;
import com.poplar.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 会员
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:57:54
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private CouponServiceFeign couponServiceFeign;

    @RequestMapping("/memberCouponList")
    public Result<Coupon> getMemberCoupon(){
        return couponServiceFeign.getCouponList();
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public Result<Member> info(@PathVariable("id") Long id){
		Member member = memberService.getById(id);

        return Result.success(member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public Result<Boolean> save(@RequestBody Member member){

        return Result.success(memberService.save(member));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("member:member:update")
    public Result<Boolean> update(@RequestBody Member member){

        return Result.success(memberService.updateById(member));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(memberService.removeByIds(Arrays.asList(ids)));
    }

}
