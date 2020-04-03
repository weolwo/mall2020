package com.poplar.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.order.domain.OrderItem;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:29:39
 */
public interface OrderItemService extends IService<OrderItem> {

    PageUtils queryPage(Map<String, Object> params);
}

