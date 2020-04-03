package com.poplar.member.dao;

import com.poplar.member.domain.IntegrationChangeHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 积分变化历史记录
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:10:23
 */
@Mapper
public interface IntegrationChangeHistoryDao extends BaseMapper<IntegrationChangeHistory> {
	
}
