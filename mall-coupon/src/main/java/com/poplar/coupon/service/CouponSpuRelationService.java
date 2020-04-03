package com.poplar.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.coupon.domain.CouponSpuRelation;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:51:34
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelation> {

    PageUtils queryPage(Map<String, Object> params);
}

