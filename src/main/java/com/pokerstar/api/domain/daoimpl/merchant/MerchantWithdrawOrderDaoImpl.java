package com.pokerstar.api.domain.daoimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IMerchantWithdrawOrderDao;
import com.pokerstar.api.domain.entity.merchant.MerchantWithdrawOrder;
import com.pokerstar.api.domain.mapper.merchant.MerchantWithdrawOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MerchantWithdrawOrderDaoImpl implements IMerchantWithdrawOrderDao {
    @Autowired
    private MerchantWithdrawOrderMapper merchantWithdrawOrderMapper;

    @Override
    public boolean addMerchantWithdrawOrder(MerchantWithdrawOrder entity) {
        return merchantWithdrawOrderMapper.addMerchantWithdrawOrder(entity);
    }

    @Override
    public int deleteMerchantWithdrawOrder(long merchantWithdrawOrderId) {
        return merchantWithdrawOrderMapper.deleteMerchantWithdrawOrder(merchantWithdrawOrderId);
    }

    @Override
    public List<MerchantWithdrawOrder> lstMerchantWithdrawOrder() {
        return merchantWithdrawOrderMapper.lstMerchantWithdrawOrder();
    }

    @Override
    public MerchantWithdrawOrder getMerchantWithdrawOrder(long orderId) {
        return merchantWithdrawOrderMapper.getMerchantWithdrawOrder(orderId);
    }

    @Override
    public MerchantWithdrawOrder getMerchantWithdrawOrderByOrderNo(String orderNo) {
        return merchantWithdrawOrderMapper.getMerchantWithdrawOrderByOrderNo(orderNo);
    }

    @Override
    public MerchantWithdrawOrder getMerchantWithdrawOrderByPlatOrderNo(String orderNo) {
        return merchantWithdrawOrderMapper.getMerchantWithdrawOrderByPlatOrderNo(orderNo);
    }

    @Override
    public int updateMerchantWithdrawOrderChannelStatus() {
        return merchantWithdrawOrderMapper.updateMerchantWithdrawOrderChannelStatus();
    }

    @Override
    public int updateMerchantWithdrawOrderMerchantStatus() {
        return merchantWithdrawOrderMapper.updateMerchantWithdrawOrderMerchantStatus();
    }
}
