package com.poplar.member.dao;

import com.poplar.member.domain.MemberReceiveAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员收货地址
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:10:22
 */
@Mapper
public interface MemberReceiveAddressDao extends BaseMapper<MemberReceiveAddress> {
	
}
