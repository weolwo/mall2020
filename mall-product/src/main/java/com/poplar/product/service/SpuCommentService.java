package com.poplar.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.product.domain.SpuComment;

import java.util.Map;

/**
 * 商品评价
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:11
 */
public interface SpuCommentService extends IService<SpuComment> {

    PageUtils queryPage(Map<String, Object> params);
}

