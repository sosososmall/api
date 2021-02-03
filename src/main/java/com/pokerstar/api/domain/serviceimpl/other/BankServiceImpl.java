package com.pokerstar.api.domain.serviceimpl.other;

import com.pokerstar.api.domain.dao.other.IBankDao;
import com.pokerstar.api.domain.entity.other.Bank;
import com.pokerstar.api.domain.service.other.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements IBankService {
    @Autowired
    private IBankDao bankDao;

    @Override
    public boolean addBank(Bank entity) {
        return bankDao.addBank(entity);
    }

    @Override
    public int deleteBank(int bankId) {
        return bankDao.deleteBank(bankId);
    }

    @Override
    public List<Bank> getAllBank() {
        return bankDao.getAllBank();
    }

    @Override
    public List<Bank> lstCountryBank(int countryId) {
        return bankDao.lstCountryBank(countryId);
    }

    @Override
    public Bank getBank(int bankId) {
        return bankDao.getBank(bankId);
    }

    @Override
    public int updateBank(Bank param) {
        return bankDao.updateBank(param);
    }
}
