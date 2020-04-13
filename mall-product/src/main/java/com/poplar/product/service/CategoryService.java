package com.poplar.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.product.domain.Category;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:11
 */
public interface CategoryService extends IService<Category> {

    PageUtils queryPage(Map<String, Object> params);

    List<Category> getCategoryList();

    Integer removeMenuByIds(Long[] catIds);

    Boolean updateCategoryDetail(Category category);
}

