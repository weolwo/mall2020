package com.poplar.ware.dao;

import com.poplar.ware.domain.Purchase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:22:22
 */
@Mapper
public interface PurchaseDao extends BaseMapper<Purchase> {
	
}
