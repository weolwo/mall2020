package com.poplar.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Query;
import com.poplar.product.dao.CategoryDao;
import com.poplar.product.domain.Category;
import com.poplar.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {


    @Autowired
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Category> page = this.page(
                new Query<Category>().getPage(params),
                new QueryWrapper<Category>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Category> getCategoryList() {
        List<Category> categories = categoryDao.selectList(null);
        //组装数据，按照等级分类
        return categories.parallelStream().filter(category -> category.getParentCid() == 0)
                .map((menu) -> {
                    menu.setChildren(getChildrens(menu, categories));
                    return menu;
                })
                .sorted((category1, category2) -> (category1.getSort() == null ? 0 : category1.getSort()) - (category2.getSort() == null ? 0 : category2.getSort()))
                .collect(Collectors.toList());
    }

    @Override
    public Integer removeMenuByIds(Long[] catIds) {
        //TODO 需要一些校验
        return categoryDao.deleteBatchIds(Arrays.asList(catIds));
    }

    private List<Category> getChildrens(Category root, List<Category> all) {
        return all.parallelStream().filter(category -> category.getParentCid() == root.getCatId())
                .map(category -> {
                    category.setChildren(getChildrens(category, all));
                    return category;
                }).sorted((category1, category2) -> (category1.getSort() == null ? 0 : category1.getSort()) - (category2.getSort() == null ? 0 : category2.getSort())
                ).collect(Collectors.toList());
    }
}