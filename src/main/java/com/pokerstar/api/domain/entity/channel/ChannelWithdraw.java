package com.pokerstar.api.domain.entity.channel;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class ChannelWithdraw implements Serializable {
    private static final long serialVersionUID = 5678604892054735969L;

    private int channel_withdraw_id;

    private int channel_id;

    private int channel_withdraw_type_id;

    private String channel_withdraw_code;

    private String channel_withdraw_code_extra;

    private BigDecimal channel_withdraw_min_amount;

    private BigDecimal channel_withdraw_max_amount;

    private boolean channel_withdraw_type_status;

    private int channel_deduct_withdraw_amount;

    private BigDecimal channel_withdraw_rate;

    private String channel_withdraw_type_remark;
}
