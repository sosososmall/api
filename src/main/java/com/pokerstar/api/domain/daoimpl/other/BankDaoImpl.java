package com.pokerstar.api.domain.daoimpl.other;

import com.pokerstar.api.domain.dao.other.IBankDao;
import com.pokerstar.api.domain.entity.other.Bank;
import com.pokerstar.api.domain.mapper.other.BankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankDaoImpl implements IBankDao {
    @Autowired
    private BankMapper bankMapper;


    @Override
    public boolean addBank(Bank entity) {
        return bankMapper.addBank(entity);
    }

    @Override
    public int deleteBank(int bankId) {
        return bankMapper.deleteBank(bankId);
    }

    @Override
    public List<Bank> getAllBank() {
        return bankMapper.getAllBank();
    }

    @Override
    public List<Bank> lstCountryBank(int countryId) {
        return bankMapper.lstCountryBank(countryId);
    }

    @Override
    public Bank getBank(int bankId) {
        return bankMapper.getBank(bankId);
    }

    @Override
    public int updateBank(Bank param) {
        return bankMapper.updateBank(param);
    }
}
