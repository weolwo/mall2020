package com.poplar.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.ware.domain.WareInfo;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:22:22
 */
public interface WareInfoService extends IService<WareInfo> {

    PageUtils queryPage(Map<String, Object> params);
}

