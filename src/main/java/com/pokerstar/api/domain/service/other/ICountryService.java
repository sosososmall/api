package com.pokerstar.api.domain.service.other;

import com.pokerstar.api.domain.entity.other.Country;

public interface ICountryService {
    boolean addCountry(Country entity);

    boolean updateCountryCurrency(Country entity);

    boolean updateCountryCurrencyRate(Country entity);
}
