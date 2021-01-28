package com.pokerstar.api.domain.daoimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IMerchantDepositOrderDao;
import com.pokerstar.api.domain.entity.merchant.MerchantDepositOrder;
import com.pokerstar.api.domain.mapper.merchant.MerchantDepositOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MerchantDepositOrderDaoImpl implements IMerchantDepositOrderDao {
    @Autowired
    private MerchantDepositOrderMapper merchantDepositOrderMapper;

    @Override
    public boolean addMerchantDepositOrder(MerchantDepositOrder entity) {
        return merchantDepositOrderMapper.addMerchantDepositOrder(entity);
    }

    @Override
    public int deleteMerchantDepositOrder(long merchantDepositOrderId) {
        return merchantDepositOrderMapper.deleteMerchantDepositOrder(merchantDepositOrderId);
    }

    @Override
    public List<MerchantDepositOrder> lstMerchantDepositOrder() {
        return merchantDepositOrderMapper.lstMerchantDepositOrder();
    }

    @Override
    public MerchantDepositOrder getMerchantDepositOrder(long orderId) {
        return merchantDepositOrderMapper.getMerchantDepositOrder(orderId);
    }

    @Override
    public MerchantDepositOrder getMerchantDepositOrderByOrderNo(int merId, String orderNo) {
        return merchantDepositOrderMapper.getMerchantDepositOrderByOrderNo(merId, orderNo);
    }

    @Override
    public MerchantDepositOrder getMerchantDepositOrderByPlatOrderNo(String orderNo) {
        return merchantDepositOrderMapper.getMerchantDepositOrderByPlatOrderNo(orderNo);
    }

    @Override
    public int updateMerchantDepositOrderChannelStatus(long merDepositOrderId, int status) {
        return merchantDepositOrderMapper.updateMerchantDepositOrderChannelStatus(merDepositOrderId, status);
    }

    @Override
    public int updateMerchantDepositOrderMerchantStatus(long merDepositOrderId, int status) {
        return merchantDepositOrderMapper.updateMerchantDepositOrderMerchantStatus(merDepositOrderId, status);
    }
}
