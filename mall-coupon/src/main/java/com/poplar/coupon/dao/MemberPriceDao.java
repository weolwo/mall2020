package com.poplar.coupon.dao;

import com.poplar.coupon.domain.MemberPrice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:51:34
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPrice> {
	
}
