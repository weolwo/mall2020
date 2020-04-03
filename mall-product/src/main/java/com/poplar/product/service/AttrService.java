package com.poplar.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.product.domain.Attr;

import java.util.Map;

/**
 * 商品属性
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:10
 */
public interface AttrService extends IService<Attr> {

    PageUtils queryPage(Map<String, Object> params);
}

