package com.poplar.member.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poplar.member.domain.MemberReceiveAddress;
import com.poplar.member.service.MemberReceiveAddressService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 会员收货地址
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:57:54
 */
@RestController
@RequestMapping("member/memberreceiveaddress")
public class MemberReceiveAddressController {
    @Autowired
    private MemberReceiveAddressService memberReceiveAddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberreceiveaddress:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = memberReceiveAddressService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberreceiveaddress:info")
    public Result<MemberReceiveAddress> info(@PathVariable("id") Long id){
		MemberReceiveAddress memberReceiveAddress = memberReceiveAddressService.getById(id);

        return Result.success(memberReceiveAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberreceiveaddress:save")
    public Result<Boolean> save(@RequestBody MemberReceiveAddress memberReceiveAddress){

        return Result.success(memberReceiveAddressService.save(memberReceiveAddress));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("member:memberreceiveaddress:update")
    public Result<Boolean> update(@RequestBody MemberReceiveAddress memberReceiveAddress){

        return Result.success(memberReceiveAddressService.updateById(memberReceiveAddress));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberreceiveaddress:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(memberReceiveAddressService.removeByIds(Arrays.asList(ids)));
    }

}
