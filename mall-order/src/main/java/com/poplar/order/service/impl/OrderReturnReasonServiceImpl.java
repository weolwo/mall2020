package com.poplar.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poplar.common.utils.PageUtils;
import com.poplar.common.utils.Query;

import com.poplar.order.dao.OrderReturnReasonDao;
import com.poplar.order.domain.OrderReturnReason;
import com.poplar.order.service.OrderReturnReasonService;


@Service("orderReturnReasonService")
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonDao, OrderReturnReason> implements OrderReturnReasonService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderReturnReason> page = this.page(
                new Query<OrderReturnReason>().getPage(params),
                new QueryWrapper<OrderReturnReason>()
        );

        return new PageUtils(page);
    }

}