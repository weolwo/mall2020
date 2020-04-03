package com.poplar.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.ware.domain.WareOrderTask;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:22:22
 */
public interface WareOrderTaskService extends IService<WareOrderTask> {

    PageUtils queryPage(Map<String, Object> params);
}

