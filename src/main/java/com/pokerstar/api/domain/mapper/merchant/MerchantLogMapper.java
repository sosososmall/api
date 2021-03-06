package com.pokerstar.api.domain.mapper.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantBalanceLog;
import com.pokerstar.api.domain.entity.merchant.MerchantLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("merchantLogMapper")
public interface MerchantLogMapper {
    boolean addMerchantBalanceLog(MerchantBalanceLog entity);

    boolean addMerchantLoginLog(MerchantLoginLog entity);

    int deleteMerchantBalanceLog(int endTimestamp);

    int deleteMerchantLoginLog(int endTimestamp);

    List<MerchantBalanceLog> lstMerchantBalanceLog();

    List<MerchantLoginLog> lstMerchantLoginLog();
}
