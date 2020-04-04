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

import com.poplar.member.domain.IntegrationChangeHistory;
import com.poplar.member.service.IntegrationChangeHistoryService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 积分变化历史记录
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:57:54
 */
@RestController
@RequestMapping("member/integrationchangehistory")
public class IntegrationChangeHistoryController {
    @Autowired
    private IntegrationChangeHistoryService integrationChangeHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:integrationchangehistory:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = integrationChangeHistoryService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:integrationchangehistory:info")
    public Result<IntegrationChangeHistory> info(@PathVariable("id") Long id){
		IntegrationChangeHistory integrationChangeHistory = integrationChangeHistoryService.getById(id);

        return Result.success(integrationChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:integrationchangehistory:save")
    public Result<Boolean> save(@RequestBody IntegrationChangeHistory integrationChangeHistory){

        return Result.success(integrationChangeHistoryService.save(integrationChangeHistory));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("member:integrationchangehistory:update")
    public Result<Boolean> update(@RequestBody IntegrationChangeHistory integrationChangeHistory){

        return Result.success(integrationChangeHistoryService.updateById(integrationChangeHistory));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:integrationchangehistory:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(integrationChangeHistoryService.removeByIds(Arrays.asList(ids)));
    }

}
