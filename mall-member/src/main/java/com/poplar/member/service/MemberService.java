package com.poplar.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.member.domain.Member;

import java.util.Map;

/**
 * 会员
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:10:23
 */
public interface MemberService extends IService<Member> {

    PageUtils queryPage(Map<String, Object> params);
}

