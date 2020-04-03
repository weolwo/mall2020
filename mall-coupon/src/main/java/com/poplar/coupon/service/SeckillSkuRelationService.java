package com.poplar.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.coupon.domain.SeckillSkuRelation;

import java.util.Map;

/**
 * 秒杀活动商品关联
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:51:34
 */
public interface SeckillSkuRelationService extends IService<SeckillSkuRelation> {

    PageUtils queryPage(Map<String, Object> params);
}

