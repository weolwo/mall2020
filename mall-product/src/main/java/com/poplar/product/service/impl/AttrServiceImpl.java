package com.poplar.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Query;
import com.poplar.product.dao.AttrDao;
import com.poplar.product.domain.Attr;
import com.poplar.product.service.AttrService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, Attr> implements AttrService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Attr> page = this.page(
                new Query<Attr>().getPage(params),
                new QueryWrapper<Attr>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryDetail(Map<String, Object> params, Long catId) {
        if (catId == 0) {
            return queryPage(params);
        }
        IPage<Attr> attrIPage = new Query<Attr>().getPage(params);
        QueryWrapper<Attr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("catelog_id", catId);
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.and(q -> q.eq("attr_name", key).or().like("attr_name", key));
        }
        return new PageUtils(page(attrIPage, queryWrapper));
    }

}