package com.pokerstar.api.domain.serviceimpl.other;

import com.pokerstar.api.domain.dao.other.ICountryDao;
import com.pokerstar.api.domain.entity.other.Country;
import com.pokerstar.api.domain.service.other.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private ICountryDao countryDao;

    @Override
    public boolean addCountry(Country entity) {
        return countryDao.addCountry(entity) > 0;
    }

    @Override
    public boolean updateCountryCurrency(Country entity) {
        return countryDao.updateCountryCurrency(entity) > 0;
    }

    @Override
    public boolean updateCountryCurrencyRate(Country entity) {
        return countryDao.updateCountryCurrencyRate(entity) > 0;
    }

    @Override
    public List<Country> getAllCountry() {
        return countryDao.getAllCountry();
    }
}
