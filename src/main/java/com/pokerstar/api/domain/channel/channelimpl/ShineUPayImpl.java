package com.pokerstar.api.domain.channel.channelimpl;

import com.pokerstar.api.domain.channel.channelbase.AbsPay;
import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.model.pay.PayData;

import java.util.Map;

public class ShineUPayImpl extends AbsPay {

    public ShineUPayImpl(ChannelMerchant channelMerchant) {
        super(channelMerchant);
    }

    @Override
    protected String pay(PayData param) {
        return null;
    }


    @Override
    public String withdraw(Map<String, Object> source) {
        return null;
    }

    @Override
    public boolean verifySign(Map<String, Object> source, String signKey) {
        return false;
    }
}
