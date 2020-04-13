package com.poplar.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.product.domain.AttrGroup;

import java.util.Map;

/**
 * 属性分组
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:11
 */
public interface AttrGroupService extends IService<AttrGroup> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);

    Long[] queryCatelogPath(Long catelogId);
}

