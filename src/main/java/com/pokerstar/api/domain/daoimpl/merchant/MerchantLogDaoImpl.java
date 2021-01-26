package com.pokerstar.api.domain.daoimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IMerchantLogDao;
import com.pokerstar.api.domain.entity.merchant.MerchantBalanceLog;
import com.pokerstar.api.domain.entity.merchant.MerchantLoginLog;
import com.pokerstar.api.domain.mapper.merchant.MerchantLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MerchantLogDaoImpl implements IMerchantLogDao {
    @Autowired
    private MerchantLogMapper merchantLogMapper;

    @Override
    public boolean addMerchantBalanceLog(MerchantBalanceLog entity) {
        return merchantLogMapper.addMerchantBalanceLog(entity);
    }

    @Override
    public boolean addMerchantLoginLog(MerchantLoginLog entity) {
        return merchantLogMapper.addMerchantLoginLog(entity);
    }

    @Override
    public int deleteMerchantBalanceLog(int endTimestamp) {
        return merchantLogMapper.deleteMerchantBalanceLog(endTimestamp);
    }

    @Override
    public int deleteMerchantLoginLog(int endTimestamp) {
        return merchantLogMapper.deleteMerchantLoginLog(endTimestamp);
    }

    @Override
    public List<MerchantBalanceLog> lstMerchantBalanceLog() {
        return merchantLogMapper.lstMerchantBalanceLog();
    }

    @Override
    public List<MerchantLoginLog> lstMerchantLoginLog() {
        return merchantLogMapper.lstMerchantLoginLog();
    }
}
