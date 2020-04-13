package com.poplar.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Query;
import com.poplar.product.dao.AttrGroupDao;
import com.poplar.product.dao.CategoryDao;
import com.poplar.product.domain.AttrGroup;
import com.poplar.product.domain.Category;
import com.poplar.product.service.AttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroup> implements AttrGroupService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<AttrGroup> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)){
            queryWrapper.eq("attr_group_id",key).or().like("attr_group_name",key);
        }
        IPage<AttrGroup> page = this.page(
                new Query<AttrGroup>().getPage(params),queryWrapper);
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        if (catelogId == 0) {
            return queryPage(params);
        }
        //构建查询条件 from pms_attr_group where catelogId =? and (attr_group_id=? or attr_group_name like ?)
        QueryWrapper<AttrGroup> wrapper = new QueryWrapper<>();
        wrapper.eq("catelog_id", catelogId);
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            wrapper.and(obj -> obj.eq("attr_group_id", key).or().like("attr_group_name", key));
        }
        IPage<AttrGroup> page = this.page(new Query<AttrGroup>().getPage(params), wrapper);
        return new PageUtils(page);
    }

    @Override
    public Long[] queryCatelogPath(Long catelogId) {
        Category category = categoryDao.selectById(catelogId);
        List<Long> path = new ArrayList<>();
        path.add(catelogId);
        while (category.getParentCid() != 0) {
            category = categoryDao.selectById(category.getParentCid());
            path.add(category.getCatId());
        }
        Collections.reverse(path);
        return path.toArray(new Long[]{});
    }

}