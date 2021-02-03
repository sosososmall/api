package com.pokerstar.api.domain.dao.other;

import com.pokerstar.api.domain.entity.other.Bank;

import java.util.List;

public interface IBankDao {
    boolean addBank(Bank entity);

    int deleteBank(int bankId);

    List<Bank> getAllBank();

    List<Bank> lstCountryBank(int countryId);

    Bank getBank(int bankId);

    int updateBank(Bank param);
}
