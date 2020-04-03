package com.poplar.ware.dao;

import com.poplar.ware.domain.WareInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:22:22
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfo> {
	
}
