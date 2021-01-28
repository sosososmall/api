package com.pokerstar.api.domain.channel.channelimpl;

import com.pokerstar.api.domain.channel.channelbase.AbsPay;
import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.model.pay.PayData;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class VNPayImpl extends AbsPay {

    public VNPayImpl(PayData payData) {
        super(payData);
    }

    @Override
    protected String pay(PayData param) {
        SortedMap<String, Object> map = new TreeMap<>();
        map.put("pay_memberid", depositRequest.getMerchant_no());
        map.put("pay_orderid", depositRequest.getPay_order_no());
        map.put("pay_applydate", "");
        map.put("pay_bankcode", param.getPay_code());
        map.put("pay_notifyurl", depositRequest.getPay_notify_url());
        map.put("pay_amount", depositRequest.getPay_amount());

        String sign = sign(map);
        map.put("pay_md5sign", sign);
        map.put("format", "json");
        map.put("pay_productname", "justshare");
        map.put("pay_receive_bankcode", param.getPay_code_extra());
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

    @Override
    protected String payCallBack() {
        return null;
    }

    @Override
    protected String withdrawCallBack() {
        return null;
    }

    @Override
    protected Set<String> paySignKeySet() {
        return null;
    }

    @Override
    protected Set<String> withdrawSignKeySet() {
        return null;
    }
}
