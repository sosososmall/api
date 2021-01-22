package com.pokerstar.api.domain.daoimpl.country;

import com.pokerstar.api.domain.dao.country.ICountryDao;
import com.pokerstar.api.domain.entity.country.Country;
import com.pokerstar.api.domain.mapper.country.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDaoImpl implements ICountryDao {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public int addCountry(Country entity) {
        countryMapper.addCountry(entity);
        return entity.getCountry_id();
    }

    @Override
    public int updateCountryCurrency(Country entity) {
       return countryMapper.updateCountryCurrency(entity);
    }
}
