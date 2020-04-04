package com.poplar.product.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poplar.product.domain.SpuComment;
import com.poplar.product.service.SpuCommentService;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Result;



/**
 * 商品评价
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 20:51:35
 */
@RestController
@RequestMapping("product/spucomment")
public class SpuCommentController {
    @Autowired
    private SpuCommentService spuCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spucomment:list")
    public Result<PageUtils> list(@RequestParam Map<String, Object> params){
        PageUtils page = spuCommentService.queryPage(params);

        return Result.success(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:spucomment:info")
    public Result<SpuComment> info(@PathVariable("id") Long id){
		SpuComment spuComment = spuCommentService.getById(id);

        return Result.success(spuComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spucomment:save")
    public Result<Boolean> save(@RequestBody SpuComment spuComment){

        return Result.success(spuCommentService.save(spuComment));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("product:spucomment:update")
    public Result<Boolean> update(@RequestBody SpuComment spuComment){

        return Result.success(spuCommentService.updateById(spuComment));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spucomment:delete")
    public Result<Boolean> delete(@RequestBody Long[] ids){

        return Result.success(spuCommentService.removeByIds(Arrays.asList(ids)));
    }

}
