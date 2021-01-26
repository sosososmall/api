package com.pokerstar.api.domain.mapper.other;

import com.pokerstar.api.domain.entity.other.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {
    boolean addCountry(Country entity);

    int updateCountryCurrency(Country entity);

    int updateCountryCurrencyRate(Country entity);

    List<Country> getAllCountry();
}
