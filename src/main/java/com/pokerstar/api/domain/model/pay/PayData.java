package com.pokerstar.api.domain.model.pay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PayData implements Serializable {
    private static final long serialVersionUID = 8069004465128589215L;

    private String merchantNo;

    private String secretKey;

    private String notifyUrl;

    private String orderId;

    private BigDecimal amount;

    private String payType;

    private String payCode;

    private long userId;

    private String desc;

    private Object extra;
}
