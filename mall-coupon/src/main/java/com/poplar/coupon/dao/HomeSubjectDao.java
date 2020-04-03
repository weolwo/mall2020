package com.poplar.coupon.dao;

import com.poplar.coupon.domain.HomeSubject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * 
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:51:34
 */
@Mapper
public interface HomeSubjectDao extends BaseMapper<HomeSubject> {
	
}
