

package com.poplar.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.modules.oss.entity.SysOssEntity;
import com.poplar.common.utils.PageUtils;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
