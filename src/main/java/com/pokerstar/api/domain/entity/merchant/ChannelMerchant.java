package com.pokerstar.api.domain.entity.merchant;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ChannelMerchant implements Serializable {
    private static final long serialVersionUID = 4656142090335596095L;

    private int channel_merchant_id;

    private int channel_id;

    private int merchant_id;

    private String channel_full_name;

    private String channel_short_name;

    private int channel_support_country_id;

    private int channel_merchant_deduct_deposit_amount;

    private int channel_merchant_deduct_withdraw_amount;

    private BigDecimal channel_merchant_deposit_rate;

    private BigDecimal channel_merchant_withdraw_rate;

    private boolean channel_status;

    private String channel_merchant_deposit_url;

    private String channel_merchant_withdraw_url;

    private long channel_merchant_create_time;

    private String channel_merchant_ip;

    private String channel_merchant_remark;
}
