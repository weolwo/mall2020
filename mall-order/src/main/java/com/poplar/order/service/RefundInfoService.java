package com.poplar.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.order.domain.RefundInfo;

import java.util.Map;

/**
 * 退款信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:29:39
 */
public interface RefundInfoService extends IService<RefundInfo> {

    PageUtils queryPage(Map<String, Object> params);
}

