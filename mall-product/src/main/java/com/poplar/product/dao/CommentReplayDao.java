package com.poplar.product.dao;

import com.poplar.product.domain.CommentReplay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:10
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplay> {
	
}
