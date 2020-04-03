package com.poplar.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.order.domain.OrderOperateHistory;

import java.util.Map;

/**
 * 订单操作历史记录
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:29:39
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistory> {

    PageUtils queryPage(Map<String, Object> params);
}

