package com.poplar.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.coupon.domain.SkuFullReduction;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:51:34
 */
public interface SkuFullReductionService extends IService<SkuFullReduction> {

    PageUtils queryPage(Map<String, Object> params);
}

