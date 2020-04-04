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

import com.poplar.member.domain.MemberStatisticsInfo;
import com.poplar.member.service.MemberStatisticsInfoService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 会员统计信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:57:54
 */
@RestController
@RequestMapping("member/memberstatisticsinfo")
public class MemberStatisticsInfoController {
    @Autowired
    private MemberStatisticsInfoService memberStatisticsInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberstatisticsinfo:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = memberStatisticsInfoService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberstatisticsinfo:info")
    public Result<MemberStatisticsInfo> info(@PathVariable("id") Long id){
		MemberStatisticsInfo memberStatisticsInfo = memberStatisticsInfoService.getById(id);

        return Result.success(memberStatisticsInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberstatisticsinfo:save")
    public Result<Boolean> save(@RequestBody MemberStatisticsInfo memberStatisticsInfo){

        return Result.success(memberStatisticsInfoService.save(memberStatisticsInfo));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("member:memberstatisticsinfo:update")
    public Result<Boolean> update(@RequestBody MemberStatisticsInfo memberStatisticsInfo){

        return Result.success(memberStatisticsInfoService.updateById(memberStatisticsInfo));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberstatisticsinfo:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(memberStatisticsInfoService.removeByIds(Arrays.asList(ids)));
    }

}
