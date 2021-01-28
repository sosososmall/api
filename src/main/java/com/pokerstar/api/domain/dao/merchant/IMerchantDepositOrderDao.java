package com.pokerstar.api.domain.dao.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantDepositOrder;

import java.util.List;

public interface IMerchantDepositOrderDao {
    boolean addMerchantDepositOrder(MerchantDepositOrder entity);

    int deleteMerchantDepositOrder(long merchantDepositOrderId);

    List<MerchantDepositOrder> lstMerchantDepositOrder();

    MerchantDepositOrder getMerchantDepositOrder(long orderId);

    MerchantDepositOrder getMerchantDepositOrderByOrderNo(int merId, String orderNo);

    MerchantDepositOrder getMerchantDepositOrderByPlatOrderNo(String orderNo);

    int updateMerchantDepositOrderChannelStatus(long merDepositOrderId, int status);

    int updateMerchantDepositOrderMerchantStatus(long merDepositOrderId, int status);
}
