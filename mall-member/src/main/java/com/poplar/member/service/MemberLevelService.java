package com.poplar.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.member.domain.MemberLevel;

import java.util.Map;

/**
 * 会员等级
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:10:22
 */
public interface MemberLevelService extends IService<MemberLevel> {

    PageUtils queryPage(Map<String, Object> params);
}

