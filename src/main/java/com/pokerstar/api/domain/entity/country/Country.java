package com.pokerstar.api.domain.entity.country;

import lombok.Data;

import java.io.Serializable;

@Data
public class Country implements Serializable {
    private static final long serialVersionUID = -8297281289462288859L;

    private int country_id;

    private String country_cn_name;

    private String country_eg_name;

    private String country_iso_code;

    private int country_sort;

    private String country_remark;
}
