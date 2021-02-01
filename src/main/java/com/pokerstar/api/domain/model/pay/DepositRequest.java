package com.pokerstar.api.domain.model.pay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DepositRequest implements Serializable {
    private static final long serialVersionUID = 6544725559702374894L;

    private String merchant_no;

    private String order_no;

    private BigDecimal pay_amount;

    private String notify_url;

    private int pay_type;

    private int pay_fee_type;

    private long datetime;

    private String extra;

    private String sign;


    private String request_url;

    private String secret_key;

    private String pay_code;

    private String pay_code_extra;
}
