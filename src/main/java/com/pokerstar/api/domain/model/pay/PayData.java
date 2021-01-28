package com.pokerstar.api.domain.model.pay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PayData implements Serializable {
    private static final long serialVersionUID = 8069004465128589215L;

    private DepositRequest request;

    private String merchant_no;

    private String secret_key;

    private String request_url;

    private String plat_notify_url;

    private String pay_code;

    private String pay_code_extra;

}
