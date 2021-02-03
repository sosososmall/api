package com.pokerstar.api.domain.mapper.other;

import com.pokerstar.api.domain.entity.other.Bank;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("bankMapper")
public interface BankMapper {
    boolean addBank(Bank entity);

    int deleteBank(int bankId);

    List<Bank> getAllBank();

    List<Bank> lstCountryBank(int countryId);

    Bank getBank(int bankId);

    int updateBank(Bank param);
}
