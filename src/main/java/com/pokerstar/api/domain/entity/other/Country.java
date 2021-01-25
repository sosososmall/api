package com.pokerstar.api.domain.entity.other;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Country implements Serializable {
    private static final long serialVersionUID = -8297281289462288859L;

    private int country_id;

    private String country_cn_name;

    private String country_eg_name;

    private String country_iso_code;

    private String country_currency_name;

    private String country_currency_iso_code;

    private String country_currency_code;

    private BigDecimal country_currency_latest_exchange_rate;

    private long country_currency_rate_update_time;

    private long country_currency_update_time;

    private int country_sort;

    private String country_remark;
}
