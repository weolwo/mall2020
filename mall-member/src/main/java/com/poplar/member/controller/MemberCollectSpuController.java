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

import com.poplar.member.domain.MemberCollectSpu;
import com.poplar.member.service.MemberCollectSpuService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 会员收藏的商品
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:57:54
 */
@RestController
@RequestMapping("member/membercollectspu")
public class MemberCollectSpuController {
    @Autowired
    private MemberCollectSpuService memberCollectSpuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:membercollectspu:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSpuService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:membercollectspu:info")
    public Result<MemberCollectSpu> info(@PathVariable("id") Long id){
		MemberCollectSpu memberCollectSpu = memberCollectSpuService.getById(id);

        return Result.success(memberCollectSpu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:membercollectspu:save")
    public Result<Boolean> save(@RequestBody MemberCollectSpu memberCollectSpu){

        return Result.success(memberCollectSpuService.save(memberCollectSpu));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("member:membercollectspu:update")
    public Result<Boolean> update(@RequestBody MemberCollectSpu memberCollectSpu){

        return Result.success(memberCollectSpuService.updateById(memberCollectSpu));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:membercollectspu:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(memberCollectSpuService.removeByIds(Arrays.asList(ids)));
    }

}
