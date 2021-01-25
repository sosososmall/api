package com.pokerstar.api.domain.entity.channel;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChannelDepositType implements Serializable {
    private static final long serialVersionUID = 5411078896343644432L;

    private int channel_deposit_type_id;

    private int channel_id;

    private String channel_deposit_type_cn_name;

    private String channel_deposit_type_eg_name;

    private String channel_deposit_type_native_name;

    private String channel_deposit_type_remark;
}
