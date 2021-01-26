package com.pokerstar.api.domain.serviceimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IMerchantLogDao;
import com.pokerstar.api.domain.entity.merchant.MerchantBalanceLog;
import com.pokerstar.api.domain.entity.merchant.MerchantLoginLog;
import com.pokerstar.api.domain.service.merchant.IMerchantLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantLogServiceImpl implements IMerchantLogService {
    @Autowired
    private IMerchantLogDao merchantLogDao;

    @Override
    public boolean addMerchantBalanceLog(MerchantBalanceLog entity) {
        return merchantLogDao.addMerchantBalanceLog(entity);
    }

    @Override
    public boolean addMerchantLoginLog(MerchantLoginLog entity) {
        return merchantLogDao.addMerchantLoginLog(entity);
    }

    @Override
    public int deleteMerchantBalanceLog(int endTimestamp) {
        return merchantLogDao.deleteMerchantBalanceLog(endTimestamp);
    }

    @Override
    public int deleteMerchantLoginLog(int endTimestamp) {
        return merchantLogDao.deleteMerchantLoginLog(endTimestamp);
    }

    @Override
    public List<MerchantBalanceLog> lstMerchantBalanceLog() {
        return merchantLogDao.lstMerchantBalanceLog();
    }

    @Override
    public List<MerchantLoginLog> lstMerchantLoginLog() {
        return merchantLogDao.lstMerchantLoginLog();
    }
}
