package com.pokerstar.api.domain.dao.other;

import com.pokerstar.api.domain.entity.other.Country;

import java.util.List;

public interface ICountryDao {
    int addCountry(Country entity);

    int updateCountryCurrency(Country entity);

    int updateCountryCurrencyRate(Country entity);

    List<Country> getAllCountry();
}
