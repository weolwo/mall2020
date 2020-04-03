package com.poplar.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.member.domain.IntegrationChangeHistory;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:10:23
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistory> {

    PageUtils queryPage(Map<String, Object> params);
}

