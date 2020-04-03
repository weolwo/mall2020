package com.poplar.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poplar.common.utils.PageUtils;
import com.poplar.member.domain.MemberReceiveAddress;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 16:10:22
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddress> {

    PageUtils queryPage(Map<String, Object> params);
}

