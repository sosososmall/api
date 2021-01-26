package com.pokerstar.api.domain.dao.other;

import com.pokerstar.api.domain.entity.other.BalanceChangeType;

import java.util.List;

public interface IBalanceChangeTypeDao {
    boolean addBalanceChangeType(BalanceChangeType entity);

    int deleteBalanceChangeType(int balanceChangeTypeId);

    List<BalanceChangeType> getAllBalanceChangeType();

    int updateBalanceChangeType(BalanceChangeType param);
}
