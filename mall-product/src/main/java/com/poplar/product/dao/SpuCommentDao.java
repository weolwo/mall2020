package com.poplar.product.dao;

import com.poplar.product.domain.SpuComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:11
 */
@Mapper
public interface SpuCommentDao extends BaseMapper<SpuComment> {
	
}
