package com.poplar.product.dao;

import com.poplar.product.domain.CategoryBrandRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌分类关联
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:10
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelation> {
	
}
