package com.pokerstar.api.domain.entity.merchant;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class MerchantDepositOrder implements Serializable {
    private static final long serialVersionUID = 8143690588483976091L;

    private long merchant_deposit_order_id;

    private int channel_merchant_id;

    private int channel_id;

    private String channel_short_name;

    private int merchant_id;

    private int channel_deposit_merchant_id;

    private String channel_merchant_number;

    private int channel_deposit_type_id;

    private String merchant_deposit_order_plat_no;

    private String merchant_deposit_order_channel_no;

    private String merchant_deposit_order_merchant_no;

    private BigDecimal merchant_deposit_order_amount;

    private BigDecimal merchant_deposit_order_fee;

    private int merchant_deposit_order_fee_type;

    private String merchant_deposit_order_notify_url;

    private String merchant_deposit_order_request_url;

    private String merchant_deposit_order_currency_iso_code;

    private String merchant_deposit_order_merchant_sign;

    private long merchant_deposit_order_create_time;

    private boolean merchant_deposit_order_notify_merchant_status;

    private boolean merchant_deposit_order_notify_channel_status;

    private String merchant_deposit_order_extra;

    private String merchant_deposit_order_remark;
}
