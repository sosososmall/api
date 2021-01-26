package com.pokerstar.api.domain.serviceimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IMerchantBalanceDao;
import com.pokerstar.api.domain.entity.merchant.MerchantBalance;
import com.pokerstar.api.domain.service.merchant.IMerchantBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantBalanceServiceImpl implements IMerchantBalanceService {
    @Autowired
    private IMerchantBalanceDao merchantBalanceDao;

    @Override
    public boolean addMerchantBalance(MerchantBalance entity) {
        return merchantBalanceDao.addMerchantBalance(entity);
    }

    @Override
    public int deleteMerchantBalance(int merchantBalanceId) {
        return merchantBalanceDao.deleteMerchantBalance(merchantBalanceId);
    }

    @Override
    public List<MerchantBalance> getAllMerchantBalance() {
        return merchantBalanceDao.getAllMerchantBalance();
    }

    @Override
    public List<MerchantBalance> lstMerchantBalance(int merchantId) {
        return merchantBalanceDao.lstMerchantBalance(merchantId);
    }

    @Override
    public MerchantBalance getMerchantBalance(int merchantBalanceId) {
        return merchantBalanceDao.getMerchantBalance(merchantBalanceId);
    }

    @Override
    public int updateMerchantBalance(MerchantBalance param) {
        return merchantBalanceDao.updateMerchantBalance(param);
    }
}
