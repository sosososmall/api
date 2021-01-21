package com.pokerstar.api.domain.entity.merchant;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Merchant implements Serializable {
    private static final long serialVersionUID = 7056804535918253527L;

    private int merchant_id;

    private int agent_id;

    private String merchant_name;

    private String merchant_phone;

    private String merchant_email;

    private BigDecimal merchant_transaction_deposit_amount;

    private BigDecimal merchant_transaction_withdraw_amount;

    private BigDecimal merchant_total_deposit_fee;

    private BigDecimal merchant_total_withdraw_fee;

    private BigDecimal merchant_balance;

    private String merchant_freeze_balance;

    private String merchant_ip;

    private String merchant_remark;
}
