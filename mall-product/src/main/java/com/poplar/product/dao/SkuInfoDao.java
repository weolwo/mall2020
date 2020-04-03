package com.poplar.product.dao;

import com.poplar.product.domain.SkuInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku信息
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:11
 */
@Mapper
public interface SkuInfoDao extends BaseMapper<SkuInfo> {
	
}
