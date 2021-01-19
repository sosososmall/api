package com.pokerstar.api.domain.entity.channel;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Channel implements Serializable {

    private static final long serialVersionUID = -8334408814157066758L;

    private int channel_id;

    private String channel_full_name;

    private  String channel_short_name;

    private String channel_deposit_url;

    private String channel_withdraw_url;

    private int channel_sort;

    private boolean channel_status;

    private  String channel_support_country;

    private int channel_deduct_deposit_amount;

    private int channel_deduct_withdraw_amount;

    private BigDecimal channel_deposit_rate;

    private BigDecimal channel_withdraw_rate;

    private  String channel_remark;
}
