

package com.poplar.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.modules.job.entity.ScheduleJobLogEntity;
import com.poplar.common.utils.PageUtils;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}
