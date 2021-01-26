package com.pokerstar.api.domain.service.merchant;

import com.pokerstar.api.domain.entity.merchant.Merchant;

import java.util.List;

public interface IMerchantService {
    boolean addMerchant(Merchant entity);

    int deleteMerchant(int merchantId);

    List<Merchant> getAllMerchant();

    int updateMerchant(Merchant param);

    int toggleMerchantStatus(int merchantId, int status);
}
