package com.pokerstar.api.domain.daoimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IMerchantDao;
import com.pokerstar.api.domain.entity.merchant.Merchant;
import com.pokerstar.api.domain.mapper.merchant.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MerchantDaoImpl implements IMerchantDao {
    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public boolean addMerchant(Merchant entity) {
        return merchantMapper.addMerchant(entity);
    }

    @Override
    public int deleteMerchant(int merchantId) {
        return merchantMapper.deleteMerchant(merchantId);
    }

    @Override
    public List<Merchant> getAllMerchant() {
        return merchantMapper.getAllMerchant();
    }

    @Override
    public int updateMerchant(Merchant param) {
        return merchantMapper.updateMerchant(param);
    }

    @Override
    public int toggleMerchantStatus(int merchantId, int status) {
        return merchantMapper.toggleMerchantStatus(merchantId, status);
    }
}
