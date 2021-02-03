package com.pokerstar.api.domain.entity.other;

import lombok.Data;

import java.io.Serializable;

@Data
public class Bank implements Serializable {
    private static final long serialVersionUID = 1813596026750639394L;

    private int bank_id;

    private String bank_name;

    private String bank_iso_code;

    private String bank_code;

    private int bank_support_country_id;

    private String bank_support_country_cn_name;

    private String bank_remark;
}
