package com.poplar.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.coupon.domain.HomeAdv;

import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:51:34
 */
public interface HomeAdvService extends IService<HomeAdv> {

    PageUtils queryPage(Map<String, Object> params);
}

