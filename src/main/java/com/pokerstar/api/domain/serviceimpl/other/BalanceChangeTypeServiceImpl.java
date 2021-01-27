package com.pokerstar.api.domain.serviceimpl.other;

import com.pokerstar.api.domain.dao.other.IBalanceChangeTypeDao;
import com.pokerstar.api.domain.entity.other.BalanceChangeType;
import com.pokerstar.api.domain.service.other.IBalanceChangeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceChangeTypeServiceImpl implements IBalanceChangeTypeService {
    @Autowired
    private IBalanceChangeTypeDao balanceChangeTypeDao;

    @Override
    public boolean addBalanceChangeType(BalanceChangeType entity) {
        return balanceChangeTypeDao.addBalanceChangeType(entity);
    }

    @Override
    public int deleteBalanceChangeType(int balanceChangeTypeId) {
        return balanceChangeTypeDao.deleteBalanceChangeType(balanceChangeTypeId);
    }

    @Override
    public List<BalanceChangeType> getAllBalanceChangeType() {
        return balanceChangeTypeDao.getAllBalanceChangeType();
    }

    @Override
    public int updateBalanceChangeType(BalanceChangeType param) {
        return balanceChangeTypeDao.updateBalanceChangeType(param);
    }
}
