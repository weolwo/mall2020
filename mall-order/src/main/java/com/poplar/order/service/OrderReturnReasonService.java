package com.poplar.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.order.domain.OrderReturnReason;

import java.util.Map;

/**
 * 退货原因
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:29:40
 */
public interface OrderReturnReasonService extends IService<OrderReturnReason> {

    PageUtils queryPage(Map<String, Object> params);
}

