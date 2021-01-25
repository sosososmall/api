package com.pokerstar.api.domain.entity.merchant;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ChannelWithdrawMerchant implements Serializable {
    private static final long serialVersionUID = -7902729307361682001L;

    private int channel_withdraw_merchant_id;

    private int channel_id;

    private int merchant_id;

    private int channel_merchant_id;

    private int channel_withdraw_id;

    private int channel_withdraw_type_id;

    private String  channel_withdraw_code;

    private String  channel_withdraw_extra_code;

    private BigDecimal channel_withdraw_min_amount;

    private BigDecimal channel_withdraw_max_amount;

    private BigDecimal channel_withdraw_merchant_min_amount;

    private BigDecimal channel_withdraw_merchant_max_amount;

    private boolean channel_withdraw_merchant_status;

    private int channel_withdraw_merchant_deduct_amount;

    private BigDecimal channel_withdraw_merchant_rate;

    private String channel_withdraw_merchant_remark;
}
