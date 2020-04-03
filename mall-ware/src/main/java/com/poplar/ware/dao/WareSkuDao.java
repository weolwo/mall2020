package com.poplar.ware.dao;

import com.poplar.ware.domain.WareSku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:22:21
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSku> {
	
}
