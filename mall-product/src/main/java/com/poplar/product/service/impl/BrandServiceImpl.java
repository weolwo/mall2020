package com.poplar.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Query;
import com.poplar.product.dao.BrandDao;
import com.poplar.product.domain.Brand;
import com.poplar.product.service.BrandService;
import com.poplar.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Map;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, Brand> implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Brand> page = this.page(
                new Query<Brand>().getPage(params),
                new QueryWrapper<Brand>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public Boolean updateBrandDetail(Brand brand) {

        int res = brandDao.updateById(brand);
        if (!StringUtils.isEmpty(brand.getName())) {
            categoryBrandRelationService.updateBrandDetail(brand);
            //TODO 关联其他
        }
        return res > 0;
    }

}