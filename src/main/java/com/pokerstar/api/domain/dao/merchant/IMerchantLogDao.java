package com.pokerstar.api.domain.dao.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantBalanceLog;
import com.pokerstar.api.domain.entity.merchant.MerchantLoginLog;

import java.util.List;

public interface IMerchantLogDao {
    boolean addMerchantBalanceLog(MerchantBalanceLog entity);

    boolean addMerchantLoginLog(MerchantLoginLog entity);

    int deleteMerchantBalanceLog(int endTimestamp);

    int deleteMerchantLoginLog(int endTimestamp);

    List<MerchantBalanceLog> lstMerchantBalanceLog();

    List<MerchantLoginLog> lstMerchantLoginLog();
}
