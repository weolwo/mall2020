package com.poplar.order.dao;

import com.poplar.order.domain.OrderSetting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:29:39
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSetting> {
	
}
