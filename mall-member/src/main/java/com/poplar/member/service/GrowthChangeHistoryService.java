package com.poplar.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.member.domain.GrowthChangeHistory;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:10:22
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistory> {

    PageUtils queryPage(Map<String, Object> params);
}

