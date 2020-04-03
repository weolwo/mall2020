package com.poplar.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.ware.domain.Purchase;

import java.util.Map;

/**
 * 采购信息
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:22:22
 */
public interface PurchaseService extends IService<Purchase> {

    PageUtils queryPage(Map<String, Object> params);
}

