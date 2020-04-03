package com.poplar.product.dao;

import com.poplar.product.domain.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:11
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {
	
}
