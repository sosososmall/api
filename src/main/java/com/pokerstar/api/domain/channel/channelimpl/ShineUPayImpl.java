package com.pokerstar.api.domain.channel.channelimpl;

import com.pokerstar.api.domain.channel.channelbase.AbsPay;
import com.pokerstar.api.domain.model.pay.DepositRequest;

import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import com.pokerstar.api.infrastructure.util.HttpUtil;
import com.pokerstar.api.infrastructure.util.Md5Util;
import com.pokerstar.api.infrastructure.util.StringUtil;

import java.util.HashMap;
import java.util.Map;


public class ShineUPayImpl extends AbsPay {

    public ShineUPayImpl(DepositRequest request) {
        super(request);
    }

    public ShineUPayImpl(WithdrawRequest request) {
        super(request);
    }

    @Override
    public String pay() {
        Map<String, Object> header = new HashMap<>(1);
        header.put("Api-Sign", sign(StringUtil.object2Json(payMap())));
        String result = HttpUtil.sendPostJson(depositRequest.getRequest_url(), StringUtil.object2Json(payMap()), header);
        return null;
    }

    @Override
    public String withdraw() {
        return null;
    }

    @Override
    public boolean verifySign() {
        return true;
    }

    @Override
    public boolean verifyPaySign() {
        return false;
    }

    @Override
    public boolean verifyWithdrawSign() {
        return false;
    }

    @Override
    protected String sign(String originalStr) {
        return Md5Util.md5(originalStr + "|" + getSecret_key());
    }


    @Override
    protected Map<String, Object> withdrawMap() {
        return null;
    }

    @Override
    protected Map<String, Object> payMap() {
        Map<String, Object> result = new HashMap<>(3);
        Map<String, Object> bodyMap = new HashMap<>(8);
        bodyMap.put("PayTypeId", "");
        bodyMap.put("Amount", depositRequest.getPay_amount());
        bodyMap.put("OrderId", depositRequest.getOrder_no());
        bodyMap.put("Details", "pay");
        bodyMap.put("UserId", "");
        bodyMap.put("IsVip", false);
        bodyMap.put("NotifyUrl", "www.baidu.com");
        bodyMap.put("RedirectUrl", "www.google.com");
        bodyMap.put("Extend1", "");
        bodyMap.put("Extend2", "");
        bodyMap.put("Extend3", "");
        bodyMap.put("Extend4", "");
        bodyMap.put("Extend5", "");

        result.put("Body", bodyMap);
        result.put("MerchantId", depositRequest.getMerchant_no());
        result.put("MerchantId", DateTimeUtil.getCurrentMillSecondTimestamp());

        return result;
    }

    @Override
    protected String payCallBack() {
        return null;
    }

    @Override
    protected String withdrawCallBack() {
        return null;
    }
}
