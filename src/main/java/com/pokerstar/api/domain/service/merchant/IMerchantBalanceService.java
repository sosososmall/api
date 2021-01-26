package com.pokerstar.api.domain.service.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantBalance;

import java.util.List;

public interface IMerchantBalanceService {
    boolean addMerchantBalance(MerchantBalance entity);

    int deleteMerchantBalance(int merchantBalanceId);

    List<MerchantBalance> getAllMerchantBalance();

    List<MerchantBalance> lstMerchantBalance(int merchantId);

    MerchantBalance getMerchantBalance(int merchantBalanceId);

    int updateMerchantBalance(MerchantBalance param);
}
