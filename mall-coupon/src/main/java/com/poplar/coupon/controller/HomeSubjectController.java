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

import com.poplar.coupon.domain.HomeSubject;
import com.poplar.coupon.service.HomeSubjectService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:56:20
 */
@RestController
@RequestMapping("coupon/homesubject")
public class HomeSubjectController {
    @Autowired
    private HomeSubjectService homeSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:homesubject:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = homeSubjectService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:homesubject:info")
    public Result<HomeSubject> info(@PathVariable("id") Long id){
		HomeSubject homeSubject = homeSubjectService.getById(id);

        return Result.success(homeSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:homesubject:save")
    public Result<Boolean> save(@RequestBody HomeSubject homeSubject){

        return Result.success(homeSubjectService.save(homeSubject));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:homesubject:update")
    public Result<Boolean> update(@RequestBody HomeSubject homeSubject){

        return Result.success(homeSubjectService.updateById(homeSubject));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:homesubject:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(homeSubjectService.removeByIds(Arrays.asList(ids)));
    }

}
