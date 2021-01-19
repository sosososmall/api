package com.pokerstar.api.domain.dto.channel;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ChannelDTO implements Serializable {
    private static final long serialVersionUID = 6730496358277390325L;

    private int id;

    private String fullName;

    private String shortName;

    private String depositUrl;

    private String withdrawUrl;

    private int sort;

    private String deductDepositAmount;

    private String deductWithdrawAmount;

    private BigDecimal depositRate;

    private BigDecimal withdrawRate;

    private boolean status;

    private  String supportCountry;

    private  String remark;
}
