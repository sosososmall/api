package com.pokerstar.api.domain.service.country;

import com.pokerstar.api.domain.entity.country.Country;

public interface ICountryService {
    boolean addCountry(Country entity);

    boolean updateCountryCurrency(Country entity);
}
