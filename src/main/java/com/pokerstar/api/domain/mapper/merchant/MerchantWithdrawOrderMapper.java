package com.pokerstar.api.domain.mapper.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantWithdrawOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("merchantWithdrawOrderMapper")
public interface MerchantWithdrawOrderMapper {
    boolean addMerchantWithdrawOrder(MerchantWithdrawOrder entity);

    int deleteMerchantWithdrawOrder(long merchantWithdrawOrderId);

    List<MerchantWithdrawOrder> lstMerchantWithdrawOrder();

    MerchantWithdrawOrder getMerchantWithdrawOrder(long orderId);

    MerchantWithdrawOrder getMerchantWithdrawOrderByOrderNo(String orderNo);

    MerchantWithdrawOrder getMerchantWithdrawOrderByPlatOrderNo(String orderNo);

    int updateMerchantWithdrawOrderChannelStatus();

    int updateMerchantWithdrawOrderMerchantStatus();
}