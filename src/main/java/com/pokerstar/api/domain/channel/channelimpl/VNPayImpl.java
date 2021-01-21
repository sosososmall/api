package com.pokerstar.api.domain.channel.channelimpl;

import com.pokerstar.api.domain.channel.channelbase.AbsPay;
import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.model.pay.PayData;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class VNPayImpl extends AbsPay {
    public VNPayImpl(ChannelMerchant channelMerchant) {
        super(channelMerchant);
    }

    @Override
    protected String pay(PayData param) {
        SortedMap<String, Object> map = new TreeMap<>();
        map.put("pay_memberid", _channelMerchant.getChannel_merchant_id());
        map.put("pay_orderid", param.getOrderId());
        map.put("pay_applydate", "");
        map.put("pay_bankcode", param.getPayType());
        map.put("pay_notifyurl", param.getNotifyUrl());
        map.put("pay_amount", param.getAmount());

        String sign = sign(map);
        map.put("pay_md5sign", sign);
        map.put("format", "json");
        map.put("pay_productname", "justshare");
        map.put("pay_receive_bankcode", param.getPayCode());
        return null;
    }

    @Override
    protected String withdraw(Map<String, Object> source) {
        return null;
    }

    @Override
    protected boolean verifySign(Map<String, Object> source, String signKey) {
        return false;
    }
}
