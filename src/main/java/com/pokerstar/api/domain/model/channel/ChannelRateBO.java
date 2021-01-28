package com.pokerstar.api.domain.model.channel;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ChannelRateBO implements Serializable {

    private static final long serialVersionUID = -3435270576394091322L;

    private int channelId;

    private int deductDepositAmount;

    private int deductWithdrawAmount;

    private BigDecimal depositRate;

    private BigDecimal withdrawRate;
}
