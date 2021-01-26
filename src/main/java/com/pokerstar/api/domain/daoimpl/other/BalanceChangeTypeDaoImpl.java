package com.pokerstar.api.domain.daoimpl.other;

import com.pokerstar.api.domain.dao.other.IBalanceChangeTypeDao;
import com.pokerstar.api.domain.entity.other.BalanceChangeType;
import com.pokerstar.api.domain.mapper.other.BalanceChangeTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BalanceChangeTypeDaoImpl implements IBalanceChangeTypeDao {
    @Autowired
    private BalanceChangeTypeMapper balanceChangeTypeMapper;

    @Override
    public boolean addBalanceChangeType(BalanceChangeType entity) {
        return balanceChangeTypeMapper.addBalanceChangeType(entity);
    }

    @Override
    public int deleteBalanceChangeType(int balanceChangeTypeId) {
        return balanceChangeTypeMapper.deleteBalanceChangeType(balanceChangeTypeId);
    }

    @Override
    public List<BalanceChangeType> getAllBalanceChangeType() {
        return balanceChangeTypeMapper.getAllBalanceChangeType();
    }

    @Override
    public int updateBalanceChangeType(BalanceChangeType param) {
        return balanceChangeTypeMapper.updateBalanceChangeType(param);
    }
}
