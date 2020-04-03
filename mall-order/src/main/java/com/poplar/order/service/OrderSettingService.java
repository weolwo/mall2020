package com.poplar.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.order.domain.OrderSetting;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:29:39
 */
public interface OrderSettingService extends IService<OrderSetting> {

    PageUtils queryPage(Map<String, Object> params);
}

