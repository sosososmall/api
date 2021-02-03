package com.pokerstar.api.domain.entity.channel;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChannelBank implements Serializable {
    private static final long serialVersionUID = 7510580092252205217L;

    private int channel_bank_id;

    private int channel_id;

    private String bank_name;

    private String bank_iso_code;

    private String bank_code;

    private int bank_support_country_id;

    private String bank_support_country_cn_name;

    private String channel_bank_remark;
}
