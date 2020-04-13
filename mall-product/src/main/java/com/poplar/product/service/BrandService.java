package com.poplar.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.product.domain.Brand;

import java.util.Map;

/**
 * 品牌
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:11
 */
public interface BrandService extends IService<Brand> {

    PageUtils queryPage(Map<String, Object> params);

    Boolean updateBrandDetail(Brand brand);
}

