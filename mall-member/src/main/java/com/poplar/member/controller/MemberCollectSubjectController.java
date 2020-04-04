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

import com.poplar.member.domain.MemberCollectSubject;
import com.poplar.member.service.MemberCollectSubjectService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 会员收藏的专题活动
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:57:54
 */
@RestController
@RequestMapping("member/membercollectsubject")
public class MemberCollectSubjectController {
    @Autowired
    private MemberCollectSubjectService memberCollectSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:membercollectsubject:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSubjectService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:membercollectsubject:info")
    public Result<MemberCollectSubject> info(@PathVariable("id") Long id){
		MemberCollectSubject memberCollectSubject = memberCollectSubjectService.getById(id);

        return Result.success(memberCollectSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:membercollectsubject:save")
    public Result<Boolean> save(@RequestBody MemberCollectSubject memberCollectSubject){

        return Result.success(memberCollectSubjectService.save(memberCollectSubject));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("member:membercollectsubject:update")
    public Result<Boolean> update(@RequestBody MemberCollectSubject memberCollectSubject){

        return Result.success(memberCollectSubjectService.updateById(memberCollectSubject));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:membercollectsubject:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(memberCollectSubjectService.removeByIds(Arrays.asList(ids)));
    }

}
