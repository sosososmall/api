package com.pokerstar.api.domain.serviceimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IMerchantWithdrawOrderDao;
import com.pokerstar.api.domain.entity.merchant.MerchantWithdrawOrder;
import com.pokerstar.api.domain.service.merchant.IMerchantWithdrawOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantWithdrawOrderServiceImpl implements IMerchantWithdrawOrderService {
    @Autowired
    private IMerchantWithdrawOrderDao merchantWithdrawOrderDao;

    @Override
    public boolean addMerchantWithdrawOrder(MerchantWithdrawOrder entity) {
        return merchantWithdrawOrderDao.addMerchantWithdrawOrder(entity);
    }

    @Override
    public int deleteMerchantWithdrawOrder(long merchantWithdrawOrderId) {
        return merchantWithdrawOrderDao.deleteMerchantWithdrawOrder(merchantWithdrawOrderId);
    }

    @Override
    public List<MerchantWithdrawOrder> lstMerchantWithdrawOrder() {
        return merchantWithdrawOrderDao.lstMerchantWithdrawOrder();
    }

    @Override
    public MerchantWithdrawOrder getMerchantWithdrawOrder(long orderId) {
        return merchantWithdrawOrderDao.getMerchantWithdrawOrder(orderId);
    }

    @Override
    public MerchantWithdrawOrder getMerchantWithdrawOrderByOrderNo(String orderNo) {
        return merchantWithdrawOrderDao.getMerchantWithdrawOrderByOrderNo(orderNo);
    }

    @Override
    public MerchantWithdrawOrder getMerchantWithdrawOrderByPlatOrderNo(String orderNo) {
        return merchantWithdrawOrderDao.getMerchantWithdrawOrderByPlatOrderNo(orderNo);
    }

    @Override
    public int updateMerchantWithdrawOrderChannelStatus(long merDepositOrderId, int status) {
        return merchantWithdrawOrderDao.updateMerchantWithdrawOrderChannelStatus(merDepositOrderId, status);
    }

    @Override
    public int updateMerchantWithdrawOrderMerchantStatus(long merDepositOrderId, int status) {
        return merchantWithdrawOrderDao.updateMerchantWithdrawOrderMerchantStatus(merDepositOrderId, status);
    }
}
