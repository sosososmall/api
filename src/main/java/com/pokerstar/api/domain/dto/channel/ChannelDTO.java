package com.pokerstar.api.domain.dto.channel;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ChannelDTO implements Serializable {
    private static final long serialVersionUID = 6730496358277390325L;

    private int id;

    private String fullName;

    private String shortName;

    private String number;

    private String secret_key;

    private String depositUrl;

    private String withdrawUrl;

    private int sort;

    private boolean status;

    private  String supportCountryCnName;

    private String supportCountryEgName;

    private String supportCountryIsoCode;

    private int supportCountryId;

    private String ip;

    private int createTime;

    private int lastUpdateTime;

    private  String remark;
}
