package com.pokerstar.api.domain.model.pay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WithdrawRequest implements Serializable {
    private static final long serialVersionUID = -1929909738227506051L;

    private String merchant_no;

    private String pay_order_no;

    private BigDecimal pay_amount;

    private String pay_real_name;

    private String pay_bank_card;

    private String pay_bank_branch;

    private String pay_notify_url;

    private int pay_type;

    private int pay_fee_type;

    private long pay_datetime;

    private String extra;

    private String sign;

}
