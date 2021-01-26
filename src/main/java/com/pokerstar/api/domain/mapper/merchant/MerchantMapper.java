package com.pokerstar.api.domain.mapper.merchant;

import com.pokerstar.api.domain.entity.merchant.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("merchantMapper")
public interface MerchantMapper {
    boolean addMerchant(Merchant entity);

    int deleteMerchant(int merchantId);

    List<Merchant> getAllMerchant();

    int updateMerchant(Merchant param);

    int toggleMerchantStatus(@Param("merchantId") int merchantId, @Param("status") int status);

    int updateMerchantPassword(@Param("merchantId") int merchantId, @Param("password") String password);

    int updateMerchantWhiteIp(@Param("merchantId") int merchantId, @Param("ip") String ip);
}
