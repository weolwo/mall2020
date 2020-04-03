package com.poplar.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.coupon.domain.SkuLadder;

import java.util.Map;

/**
 * 商品阶梯价格
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:51:34
 */
public interface SkuLadderService extends IService<SkuLadder> {

    PageUtils queryPage(Map<String, Object> params);
}

