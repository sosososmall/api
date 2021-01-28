package com.pokerstar.api.domain.serviceimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IMerchantDepositOrderDao;
import com.pokerstar.api.domain.entity.merchant.MerchantDepositOrder;
import com.pokerstar.api.domain.service.merchant.IMerchantDepositOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantDepositOrderServiceImpl implements IMerchantDepositOrderService {
    @Autowired
    private IMerchantDepositOrderDao merchantDepositOrderDao;

    @Override
    public boolean addMerchantDepositOrder(MerchantDepositOrder entity) {
        return merchantDepositOrderDao.addMerchantDepositOrder(entity);
    }

    @Override
    public int deleteMerchantDepositOrder(long merchantDepositOrderId) {
        return merchantDepositOrderDao.deleteMerchantDepositOrder(merchantDepositOrderId);
    }

    @Override
    public List<MerchantDepositOrder> lstMerchantDepositOrder() {
        return merchantDepositOrderDao.lstMerchantDepositOrder();
    }

    @Override
    public MerchantDepositOrder getMerchantDepositOrder(long orderId) {
        return merchantDepositOrderDao.getMerchantDepositOrder(orderId);
    }

    @Override
    public MerchantDepositOrder getMerchantDepositOrderByOrderNo(String orderNo) {
        return merchantDepositOrderDao.getMerchantDepositOrderByOrderNo(orderNo);
    }

    @Override
    public MerchantDepositOrder getMerchantDepositOrderByPlatOrderNo(String orderNo) {
        return merchantDepositOrderDao.getMerchantDepositOrderByPlatOrderNo(orderNo);
    }

    @Override
    public int updateMerchantDepositOrderChannelStatus(long merDepositOrderId, int status) {
        return merchantDepositOrderDao.updateMerchantDepositOrderChannelStatus(merDepositOrderId, status);
    }

    @Override
    public int updateMerchantDepositOrderMerchantStatus(long merDepositOrderId, int status) {
        return merchantDepositOrderDao.updateMerchantDepositOrderMerchantStatus(merDepositOrderId, status);
    }
}
