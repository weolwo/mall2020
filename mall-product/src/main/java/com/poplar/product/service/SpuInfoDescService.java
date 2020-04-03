package com.poplar.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.product.domain.SpuInfoDesc;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:10
 */
public interface SpuInfoDescService extends IService<SpuInfoDesc> {

    PageUtils queryPage(Map<String, Object> params);
}

