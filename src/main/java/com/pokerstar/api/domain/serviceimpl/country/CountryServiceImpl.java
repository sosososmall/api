package com.pokerstar.api.domain.serviceimpl.country;

import com.pokerstar.api.domain.dao.country.ICountryDao;
import com.pokerstar.api.domain.entity.country.Country;
import com.pokerstar.api.domain.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private ICountryDao countryDao;

    @Override
    public boolean addCountry(Country entity) {
        return countryDao.addCountry(entity) > 0;
    }
}
