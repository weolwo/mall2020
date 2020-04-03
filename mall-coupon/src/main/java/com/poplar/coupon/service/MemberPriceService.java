package com.poplar.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.coupon.domain.MemberPrice;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:51:34
 */
public interface MemberPriceService extends IService<MemberPrice> {

    PageUtils queryPage(Map<String, Object> params);
}

