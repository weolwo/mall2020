package com.poplar.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.order.domain.OrderReturnApply;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:29:40
 */
public interface OrderReturnApplyService extends IService<OrderReturnApply> {

    PageUtils queryPage(Map<String, Object> params);
}

