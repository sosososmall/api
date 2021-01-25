package com.pokerstar.api.domain.entity.merchant;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class MerchantBalance implements Serializable {
    private static final long serialVersionUID = -6564082315176506830L;

    private long merchant_balance_id;

    private int merchant_id;

    private String merchant_balance_currency_iso_code;

    private BigDecimal merchant_balance_amount;

    private BigDecimal merchant_balance_freeze_amount;

    private BigDecimal merchant_balance_transaction_deposit_amount;

    private BigDecimal merchant_balance_transaction_withdraw_amount;

    private BigDecimal merchant_balance_total_deposit_fee;

    private BigDecimal merchant_balance_total_withdraw_fee;

    private String merchant_balance_remark;
}
