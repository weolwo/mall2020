package com.poplar.product.dao;

import com.poplar.product.domain.Attr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:10
 */
@Mapper
public interface AttrDao extends BaseMapper<Attr> {
	
}
