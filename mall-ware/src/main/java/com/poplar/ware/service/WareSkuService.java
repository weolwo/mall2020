package com.poplar.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.ware.domain.WareSku;

import java.util.Map;

/**
 * 商品库存
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:22:21
 */
public interface WareSkuService extends IService<WareSku> {

    PageUtils queryPage(Map<String, Object> params);
}

