package com.poplar.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.ware.domain.PurchaseDetail;

import java.util.Map;

/**
 * 
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:22:22
 */
public interface PurchaseDetailService extends IService<PurchaseDetail> {

    PageUtils queryPage(Map<String, Object> params);
}

