package com.poplar.order.dao;

import com.poplar.order.domain.RefundInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款信息
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:29:39
 */
@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfo> {
	
}
