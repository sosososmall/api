package com.pokerstar.api.domain.mapper.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantDepositOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("merchantDepositOrderMapper")
public interface MerchantDepositOrderMapper {
    boolean addMerchantDepositOrder(MerchantDepositOrder entity);

    int deleteMerchantDepositOrder(long merchantDepositOrderId);

    List<MerchantDepositOrder> lstMerchantDepositOrder();

    MerchantDepositOrder getMerchantDepositOrder(long orderId);

    MerchantDepositOrder getMerchantDepositOrderByOrderNo(String orderNo);

    MerchantDepositOrder getMerchantDepositOrderByPlatOrderNo(String orderNo);

    int updateMerchantDepositOrderChannelStatus();

    int updateMerchantDepositOrderMerchantStatus();
}
