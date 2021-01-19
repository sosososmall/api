package com.pokerstar.api.domain.mapper.country;

import com.pokerstar.api.domain.entity.country.Country;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CountryMapper {
    boolean addCountry(Country entity);
}
