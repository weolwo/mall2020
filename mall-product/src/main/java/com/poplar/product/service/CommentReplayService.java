package com.poplar.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.product.domain.CommentReplay;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:10
 */
public interface CommentReplayService extends IService<CommentReplay> {

    PageUtils queryPage(Map<String, Object> params);
}

