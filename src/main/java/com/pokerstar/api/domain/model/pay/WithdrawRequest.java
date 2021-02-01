package com.pokerstar.api.domain.model.pay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WithdrawRequest implements Serializable {
    private static final long serialVersionUID = -1929909738227506051L;

    private String merchant_no;

    private String order_no;

    private BigDecimal pay_amount;

    private String real_name;

    private String bank_card;

    private String bank_branch;

    private String notify_url;

    private int pay_type;

    private int pay_fee_type;

    private long pay_datetime;

    private String extra;

    private String sign;


    private String request_url;

    private String secret_key;

    private String pay_code;

    private String pay_code_extra;
}
