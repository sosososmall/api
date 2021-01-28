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

    private String channel_number;

    private String channel_secret_key;

    private String channel_deposit_url;

    private String channel_withdraw_url;

    private int channel_sort;

    private boolean channel_status;

    private  String channel_support_country_cn_name;

    private  String channel_support_country_eg_name;

    private  String channel_support_country_iso_code;

    private int channel_support_country_id;

    private String channel_ip;

    private long channel_create_time;

    private long channel_last_update_time;

    private  String channel_remark;
}
