package com.pokerstar.api.domain.mapper.other;

import com.pokerstar.api.domain.entity.other.BalanceChangeType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("balanceChangeTypeMapper")
public interface BalanceChangeTypeMapper {
    boolean addBalanceChangeType(BalanceChangeType entity);

    int deleteBalanceChangeType(int balanceChangeTypeId);

    List<BalanceChangeType> getAllBalanceChangeType();

    int updateBalanceChangeType(BalanceChangeType param);
}
