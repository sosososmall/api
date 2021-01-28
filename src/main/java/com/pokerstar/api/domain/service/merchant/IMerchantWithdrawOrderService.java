package com.pokerstar.api.domain.service.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantWithdrawOrder;

import java.util.List;

public interface IMerchantWithdrawOrderService {
    boolean addMerchantWithdrawOrder(MerchantWithdrawOrder entity);

    int deleteMerchantWithdrawOrder(long merchantWithdrawOrderId);

    List<MerchantWithdrawOrder> lstMerchantWithdrawOrder();

    MerchantWithdrawOrder getMerchantWithdrawOrder(long orderId);

    MerchantWithdrawOrder getMerchantWithdrawOrderByOrderNo(String orderNo);

    MerchantWithdrawOrder getMerchantWithdrawOrderByPlatOrderNo(String orderNo);

    int updateMerchantWithdrawOrderChannelStatus(long merDepositOrderId, int status);

    int updateMerchantWithdrawOrderMerchantStatus(long merDepositOrderId, int status);
}
