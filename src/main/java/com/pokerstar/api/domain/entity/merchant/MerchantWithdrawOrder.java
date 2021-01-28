package com.pokerstar.api.domain.entity.merchant;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class MerchantWithdrawOrder implements Serializable {
    private static final long serialVersionUID = -5310722460483642126L;

    private long merchant_withdraw_order_id;

    private int channel_merchant_id;

    private int channel_id;

    private String channel_short_name;

    private int merchant_id;

    private int channel_withdraw_merchant_id;

    private int channel_withdraw_type_id;

    private String channel_merchant_number;

    private String merchant_withdraw_order_merchant_no;

    private String merchant_withdraw_order_plat_no;

    private String merchant_withdraw_order_channel_no;

    private BigDecimal merchant_withdraw_order_amount;

    private BigDecimal merchant_withdraw_order_fee;

    private int merchant_withdraw_order_fee_type;

    private String merchant_withdraw_order_real_name;

    private String merchant_withdraw_order_bank_code;

    private String merchant_withdraw_order_bank_card;

    private String merchant_withdraw_order_bank_branch;

    private String merchant_withdraw_order_notify_url;

    private String merchant_withdraw_order_request_url;

    private String merchant_withdraw_order_currency_iso_code;

    private String merchant_withdraw_order_merchant_sign;

    private long merchant_withdraw_order_create_time;

    private boolean merchant_withdraw_order_notify_merchant_status;

    private boolean merchant_withdraw_order_notify_channel_status;

    private String merchant_withdraw_order_remark;
}
