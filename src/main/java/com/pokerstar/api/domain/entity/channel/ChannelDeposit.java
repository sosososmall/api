package com.pokerstar.api.domain.entity.channel;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ChannelDeposit implements Serializable {
    private static final long serialVersionUID = 5439117543250955091L;

    private int channel_deposit_id;

    private int channel_id;

    private int channel_support_country_id;

    private int channel_deposit_type_id;

    private String channel_deposit_code;

    private String channel_deposit_code_extra;

    private BigDecimal channel_deposit_min_amount;

    private BigDecimal channel_deposit_max_amount;

    private boolean channel_deposit_type_status;

    private int channel_deduct_deposit_amount;

    private BigDecimal channel_deposit_rate;

    private String channel_deposit_type_remark;
}
