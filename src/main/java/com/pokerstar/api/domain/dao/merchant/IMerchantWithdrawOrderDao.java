package com.pokerstar.api.domain.dao.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantWithdrawOrder;

import java.util.List;

public interface IMerchantWithdrawOrderDao {
    boolean addMerchantWithdrawOrder(MerchantWithdrawOrder entity);

    int deleteMerchantWithdrawOrder(long merchantWithdrawOrderId);

    List<MerchantWithdrawOrder> lstMerchantWithdrawOrder();

    MerchantWithdrawOrder getMerchantWithdrawOrder(long orderId);

    MerchantWithdrawOrder getMerchantWithdrawOrderByOrderNo(String orderNo);

    MerchantWithdrawOrder getMerchantWithdrawOrderByPlatOrderNo(String orderNo);

    int updateMerchantWithdrawOrderChannelStatus();

    int updateMerchantWithdrawOrderMerchantStatus();
}
