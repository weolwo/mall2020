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

import com.poplar.member.domain.GrowthChangeHistory;
import com.poplar.member.service.GrowthChangeHistoryService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 成长值变化历史记录
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:57:54
 */
@RestController
@RequestMapping("member/growthchangehistory")
public class GrowthChangeHistoryController {
    @Autowired
    private GrowthChangeHistoryService growthChangeHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:growthchangehistory:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = growthChangeHistoryService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:growthchangehistory:info")
    public Result<GrowthChangeHistory> info(@PathVariable("id") Long id){
		GrowthChangeHistory growthChangeHistory = growthChangeHistoryService.getById(id);

        return Result.success(growthChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:growthchangehistory:save")
    public Result<Boolean> save(@RequestBody GrowthChangeHistory growthChangeHistory){

        return Result.success(growthChangeHistoryService.save(growthChangeHistory));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("member:growthchangehistory:update")
    public Result<Boolean> update(@RequestBody GrowthChangeHistory growthChangeHistory){

        return Result.success(growthChangeHistoryService.updateById(growthChangeHistory));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:growthchangehistory:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(growthChangeHistoryService.removeByIds(Arrays.asList(ids)));
    }

}
