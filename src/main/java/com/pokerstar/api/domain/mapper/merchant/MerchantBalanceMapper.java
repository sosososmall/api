package com.pokerstar.api.domain.mapper.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantBalance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("merchantBalanceMapper")
public interface MerchantBalanceMapper {
    boolean addMerchantBalance(MerchantBalance entity);

    int deleteMerchantBalanceById(int merchantBalanceId);

    int deleteMerchantBalance(int merchantId);

    List<MerchantBalance> getAllMerchantBalance();

    List<MerchantBalance> lstMerchantBalance(int merchantId);

    MerchantBalance getMerchantBalance(int merchantBalanceId);

    int updateMerchantBalance(MerchantBalance param);
}
