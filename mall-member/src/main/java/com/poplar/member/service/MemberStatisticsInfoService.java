package com.poplar.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.member.domain.MemberStatisticsInfo;

import java.util.Map;

/**
 * 会员统计信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:10:22
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfo> {

    PageUtils queryPage(Map<String, Object> params);
}

