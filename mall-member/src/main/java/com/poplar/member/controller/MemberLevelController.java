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

import com.poplar.member.domain.MemberLevel;
import com.poplar.member.service.MemberLevelService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 会员等级
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:57:54
 */
@RestController
@RequestMapping("member/memberlevel")
public class MemberLevelController {
    @Autowired
    private MemberLevelService memberLevelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberlevel:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = memberLevelService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberlevel:info")
    public Result<MemberLevel> info(@PathVariable("id") Long id){
		MemberLevel memberLevel = memberLevelService.getById(id);

        return Result.success(memberLevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberlevel:save")
    public Result<Boolean> save(@RequestBody MemberLevel memberLevel){

        return Result.success(memberLevelService.save(memberLevel));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("member:memberlevel:update")
    public Result<Boolean> update(@RequestBody MemberLevel memberLevel){

        return Result.success(memberLevelService.updateById(memberLevel));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberlevel:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(memberLevelService.removeByIds(Arrays.asList(ids)));
    }

}
