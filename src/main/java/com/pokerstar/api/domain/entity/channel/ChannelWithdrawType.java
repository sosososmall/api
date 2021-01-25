package com.pokerstar.api.domain.entity.channel;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChannelWithdrawType implements Serializable {
    private static final long serialVersionUID = 9222713466189611225L;

    private int channel_withdraw_type_id;

    private int channel_id;

    private String channel_withdraw_type_cn_name;

    private String channel_withdraw_type_eg_name;

    private String channel_withdraw_type_native_name;

    private String channel_withdraw_type_remark;
}
