package com.pokerstar.api.domain.model.pay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DepositNotify implements Serializable {
    private static final long serialVersionUID = -1937302528994659635L;

    private int code;

    private String msg;

    private String order_no;

    private String plat_order_no;

    private BigDecimal amount;

    private String sign;
}
