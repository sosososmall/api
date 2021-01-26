package com.pokerstar.api.domain.serviceimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IMerchantDao;
import com.pokerstar.api.domain.entity.merchant.Merchant;
import com.pokerstar.api.domain.service.merchant.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements IMerchantService {
    @Autowired
    private IMerchantDao merchantDao;

    @Override
    public boolean addMerchant(Merchant entity) {
        return merchantDao.addMerchant(entity);
    }

    @Override
    public int deleteMerchant(int merchantId) {
        return merchantDao.deleteMerchant(merchantId);
    }

    @Override
    public List<Merchant> getAllMerchant() {
        return merchantDao.getAllMerchant();
    }

    @Override
    public int updateMerchant(Merchant param) {
        return merchantDao.updateMerchant(param);
    }

    @Override
    public int toggleMerchantStatus(int merchantId, int status) {
        return merchantDao.toggleMerchantStatus(merchantId, status);
    }
}
