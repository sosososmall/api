package com.pokerstar.api.domain.model.channel;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChannelIp implements Serializable {
    private static final long serialVersionUID = -1803831044656500973L;

    private int channelId;

    private String ip;
}
