package com.poplar.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Query;
import com.poplar.product.dao.CategoryBrandRelationDao;
import com.poplar.product.domain.Brand;
import com.poplar.product.domain.Category;
import com.poplar.product.domain.CategoryBrandRelation;
import com.poplar.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelation> implements CategoryBrandRelationService {

    @Autowired
    private CategoryBrandRelationDao categoryBrandRelationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelation> page = this.page(
                new Query<CategoryBrandRelation>().getPage(params),
                new QueryWrapper<CategoryBrandRelation>()
        );

        return new PageUtils(page);
    }

    @Override
    public void updateBrandDetail(Brand brand) {
        categoryBrandRelationDao.update(new CategoryBrandRelation(), new UpdateWrapper<CategoryBrandRelation>().eq("brand_id", brand.getBrandId()).set("brand_name", brand.getName()));
    }

    @Override
    public void updateCategoryDetail(Category category) {
        categoryBrandRelationDao.updateCategoryDetail(category.getCatId(), category.getName());

    }

}