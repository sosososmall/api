package com.pokerstar.api.domain.entity.report;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ChannelMerchantDailyReport implements Serializable {
    private static final long serialVersionUID = -8638525041133274162L;

    private int channel_merchant_daily_report_id;

    private int merchant_id;

    private int channel_id;

    private BigDecimal channel_merchant_daily_report_deposit_amount;

    private BigDecimal channel_merchant_daily_report_withdraw_amount;

    private BigDecimal channel_merchant_daily_report_deposit_fee;

    private BigDecimal channel_merchant_daily_report_withdraw_fee;

    private int channel_merchant_daily_report_year;

    private int channel_merchant_daily_report_month;

    private int channel_merchant_daily_report_week;

    private int channel_merchant_daily_report_day;

    private long channel_merchant_daily_report_add_time;

    private String channel_merchant_daily_report_currency_iso_code;
}
