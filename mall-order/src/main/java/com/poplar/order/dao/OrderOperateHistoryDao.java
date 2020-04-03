package com.poplar.order.dao;

import com.poplar.order.domain.OrderOperateHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:29:39
 */
@Mapper
public interface OrderOperateHistoryDao extends BaseMapper<OrderOperateHistory> {
	
}
