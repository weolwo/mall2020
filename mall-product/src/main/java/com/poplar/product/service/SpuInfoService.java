package com.poplar.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.product.domain.SpuInfo;

import java.util.Map;

/**
 * spu信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:10
 */
public interface SpuInfoService extends IService<SpuInfo> {

    PageUtils queryPage(Map<String, Object> params);
}

