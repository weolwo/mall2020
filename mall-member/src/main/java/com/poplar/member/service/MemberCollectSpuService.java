package com.poplar.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.member.domain.MemberCollectSpu;

import java.util.Map;

/**
 * 会员收藏的商品
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:10:23
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpu> {

    PageUtils queryPage(Map<String, Object> params);
}

