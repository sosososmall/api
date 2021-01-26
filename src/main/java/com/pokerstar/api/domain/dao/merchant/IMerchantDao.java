package com.pokerstar.api.domain.dao.merchant;

import com.pokerstar.api.domain.entity.merchant.Merchant;

import java.util.List;

public interface IMerchantDao {
    boolean addMerchant(Merchant entity);

    int deleteMerchant(int merchantId);

    List<Merchant> getAllMerchant();

    int updateMerchant(Merchant param);

    int toggleMerchantStatus(int merchantId, int status);
}
