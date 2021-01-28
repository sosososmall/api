package com.pokerstar.api.domain.mapper.merchant;

import com.pokerstar.api.domain.entity.merchant.MerchantDepositOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("merchantDepositOrderMapper")
public interface MerchantDepositOrderMapper {
    boolean addMerchantDepositOrder(MerchantDepositOrder entity);

    int deleteMerchantDepositOrder(long merchantDepositOrderId);

    List<MerchantDepositOrder> lstMerchantDepositOrder();

    List<MerchantDepositOrder> lstMerchantDepositOrderByMerchantId(int merchantId);

    MerchantDepositOrder getMerchantDepositOrder(long orderId);

    MerchantDepositOrder getMerchantDepositOrderByOrderNo(@Param("merId") int merId, @Param("orderNO") String orderNO);

    MerchantDepositOrder getMerchantDepositOrderByPlatOrderNo(String platOrderNo);

    int updateMerchantDepositOrderChannelStatus(@Param("orderID") long orderId, @Param("status") int status);

    int updateMerchantDepositOrderMerchantStatus(@Param("orderID") long orderId, @Param("status") int status);
}
