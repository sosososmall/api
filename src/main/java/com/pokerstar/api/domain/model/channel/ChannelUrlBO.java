package com.pokerstar.api.domain.model.channel;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChannelUrlBO implements Serializable {
    private static final long serialVersionUID = -8047547545957510438L;

    private int channelId;

    private String depositUrl;

    private String withdrawUrl;
}
