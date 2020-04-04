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

import com.poplar.member.domain.MemberLoginLog;
import com.poplar.member.service.MemberLoginLogService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 会员登录记录
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:57:54
 */
@RestController
@RequestMapping("member/memberloginlog")
public class MemberLoginLogController {
    @Autowired
    private MemberLoginLogService memberLoginLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberloginlog:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = memberLoginLogService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberloginlog:info")
    public Result<MemberLoginLog> info(@PathVariable("id") Long id){
		MemberLoginLog memberLoginLog = memberLoginLogService.getById(id);

        return Result.success(memberLoginLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberloginlog:save")
    public Result<Boolean> save(@RequestBody MemberLoginLog memberLoginLog){

        return Result.success(memberLoginLogService.save(memberLoginLog));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("member:memberloginlog:update")
    public Result<Boolean> update(@RequestBody MemberLoginLog memberLoginLog){

        return Result.success(memberLoginLogService.updateById(memberLoginLog));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberloginlog:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(memberLoginLogService.removeByIds(Arrays.asList(ids)));
    }

}
