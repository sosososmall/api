package com.pokerstar.api.domain.service.other;

import com.pokerstar.api.domain.entity.other.BalanceChangeType;

import java.util.List;

public interface IBalanceChangeTypeService {
    boolean addBalanceChangeType(BalanceChangeType entity);

    int deleteBalanceChangeType(int balanceChangeTypeId);

    List<BalanceChangeType> getAllBalanceChangeType();

    int updateBalanceChangeType(BalanceChangeType param);
}
