package com.poplar.coupon.dao;

import com.poplar.coupon.domain.CouponHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:51:34
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistory> {
	
}
