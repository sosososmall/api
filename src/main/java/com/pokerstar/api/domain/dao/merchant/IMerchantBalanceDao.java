package com.pokerstar.api.domain.dao.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantBalance;

import java.util.List;

public interface IMerchantBalanceDao {
    boolean addMerchantBalance(MerchantBalance entity);

    int deleteMerchantBalance(int merchantBalanceId);

    List<MerchantBalance> getAllMerchantBalance();

    List<MerchantBalance> lstMerchantBalance(int merchantId);

    MerchantBalance getMerchantBalance(int merchantBalanceId);

    int updateMerchantBalance(MerchantBalance param);
}
