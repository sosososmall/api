package com.pokerstar.api.infrastructure.enums;

public enum RedisDirKeyEnum {
    /**
     * dir = CN,
     * key = country_id, value = country
     */
    COUNTRY("CN"),
    /**
     * dir = CH,
     * key = channel_id, value = channel
     */
    CHANNEL("CH"),
    /**
     * dir = CH_D,
     * key = channel_deposit_id, value = channel_deposit
     */
    CHANNEL_DEPOSIT("CH_D"),
    /**
     * dir = MER,
     * key = merchant_id, value = merchant
     */
    MERCHANT("MER"),
    /**
     * dir = CH_MER,
     * key = channel_merchant_id, value = channel_merchant
     */
    CHANNEL_MERCHANT("CH_MER"),
    /**
     * dir = CH_D_MER,
     * key = channel_deposit_merchant_id, value = channel_deposit_merchant
     * key = merchant_id + "_" + channel_deposit_type_id, value = channel_deposit_merchant
     */
    CHANNEL_DEPOSIT_MERCHANT("CH_D_MER"),
    /**
     * dir = CH_W_MER,
     * key = channel_withdraw_merchant_id, value = channel_withdraw_merchant
     * key = merchant_id + "_" + channel_withdraw_type_id, value = channel_deposit_merchant
     */
    CHANNEL_WITHDRAW_MERCHANT("CH_W_MER"),
    ;

    private String dirKey;

    RedisDirKeyEnum(String dirKey) {
        this.dirKey = dirKey;
    }

    public String getDirKey() {
        return dirKey;
    }

}
