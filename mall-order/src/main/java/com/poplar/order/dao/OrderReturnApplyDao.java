package com.poplar.order.dao;

import com.poplar.order.domain.OrderReturnApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单退货申请
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:29:40
 */
@Mapper
public interface OrderReturnApplyDao extends BaseMapper<OrderReturnApply> {
	
}
