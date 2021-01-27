package com.pokerstar.api.infrastructure.enums;

public enum RedisDirKeyEnum {
    COUNTRY("CN", "{country_id}", ""),
    CHANNEL("CH", "{channel_id}", ""),
    CHANNEL_DEPOSIT("CH_D", "{channel_deposit_id}", ""),
    ;

    private String dirKey;

    RedisDirKeyEnum(String dirKey, String key, String keyDesc) {
        this.dirKey = dirKey;
    }

    public String getDirKey() {
        return dirKey;
    }

}
