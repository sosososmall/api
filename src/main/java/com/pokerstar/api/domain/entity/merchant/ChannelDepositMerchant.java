package com.pokerstar.api.domain.entity.merchant;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ChannelDepositMerchant implements Serializable {
    private static final long serialVersionUID = -8745104172854421966L;

    private int channel_deposit_merchant_id;

    private int channel_id;

    private int merchant_id;

    private int channel_merchant_id;

    private int channel_deposit_id;

    private int channel_deposit_type_id;

    private String channel_deposit_code;

    private String channel_deposit_extra_code;

    private BigDecimal channel_deposit_min_amount;

    private BigDecimal channel_deposit_max_amount;

    private BigDecimal channel_deposit_merchant_min_amount;

    private BigDecimal channel_deposit_merchant_max_amount;

    private boolean channel_deposit_merchant_status;

    private int channel_deposit_merchant_deduct_amount;

    private BigDecimal channel_deposit_merchant_rate;

    private String channel_deposit_merchant_remark;
}
