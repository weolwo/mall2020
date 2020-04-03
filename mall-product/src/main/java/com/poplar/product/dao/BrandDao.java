package com.poplar.product.dao;

import com.poplar.product.domain.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:11
 */
@Mapper
public interface BrandDao extends BaseMapper<Brand> {
	
}
