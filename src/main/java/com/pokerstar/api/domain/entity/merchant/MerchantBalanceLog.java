package com.pokerstar.api.domain.entity.merchant;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class MerchantBalanceLog implements Serializable {
    private static final long serialVersionUID = 1152301969514879051L;

    private long merchant_balance_log_id;

    private int merchant_id;

    private String merchant_balance_log_currency_iso_code;

    private BigDecimal merchant_balance_log_before;

    private BigDecimal merchant_balance_log_after;

    private BigDecimal merchant_balance_log_balance;

    private String merchant_balance_log_source;

    private long merchant_balance_log_create_time;

    private int merchant_balance_type_id;

    private String merchant_balance_log_remark;
}
