package com.pokerstar.api.domain.daoimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IMerchantBalanceDao;
import com.pokerstar.api.domain.entity.merchant.MerchantBalance;
import com.pokerstar.api.domain.mapper.merchant.MerchantBalanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MerchantBalanceDaoImpl implements IMerchantBalanceDao {
    @Autowired
    private MerchantBalanceMapper merchantBalanceMapper;

    @Override
    public boolean addMerchantBalance(MerchantBalance entity) {
        return merchantBalanceMapper.addMerchantBalance(entity);
    }

    @Override
    public int deleteMerchantBalance(int merchantBalanceId) {
        return merchantBalanceMapper.deleteMerchantBalance(merchantBalanceId);
    }

    @Override
    public List<MerchantBalance> getAllMerchantBalance() {
        return merchantBalanceMapper.getAllMerchantBalance();
    }

    @Override
    public List<MerchantBalance> lstMerchantBalance(int merchantId) {
        return merchantBalanceMapper.lstMerchantBalance(merchantId);
    }

    @Override
    public MerchantBalance getMerchantBalance(int merchantBalanceId) {
        return merchantBalanceMapper.getMerchantBalance(merchantBalanceId);
    }

    @Override
    public int updateMerchantBalance(MerchantBalance param) {
        return merchantBalanceMapper.updateMerchantBalance(param);
    }
}
