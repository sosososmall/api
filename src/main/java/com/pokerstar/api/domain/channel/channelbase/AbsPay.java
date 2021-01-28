package com.pokerstar.api.domain.channel.channelbase;

import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.model.pay.DepositRequest;
import com.pokerstar.api.domain.model.pay.PayData;
import com.pokerstar.api.infrastructure.util.Md5Util;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 支付通道基类
 */
@Data
public abstract class AbsPay {
    private static Logger Log = LoggerFactory.getLogger(AbsPay.class);

    protected PayData payData;

    protected DepositRequest depositRequest;

    protected String paySuccessMsg = "success";

    protected String withdrawSuccessMsg = "success";

    private static ConcurrentMap<String, AbsPay> channelMap = new ConcurrentHashMap<>(8);

    private AbsPay() {
    }

    public AbsPay(PayData payData) {
        this.payData = payData;
        this.depositRequest = payData.getRequest();
    }


    /**
     * 获取支付通道实例
     *
     * @param payData
     * @return
     */
    public static AbsPay getInstance(PayData payData) {
        if (channelMap.containsKey(payData.getShort_name())) {
            return channelMap.get(payData.getShort_name());
        }

        String className = "com.pokerstar.api.domain.channel.channelimpl." + payData.getShort_name() + "PayImpl";

        AbsPay payImpl = null;
        try {
            Class<?> clz = Class.forName(className);
            payImpl = (AbsPay) clz.getConstructor(PayData.class).newInstance(payData);
            channelMap.putIfAbsent(payData.getShort_name(), payImpl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return payImpl;
    }

    /**
     * 构建待加密原始字符串
     *
     * @param source
     * @return key=val&key=val
     */
    protected String buildKeyValStr(Map<String, Object> source) {
        StringBuffer sb = new StringBuffer(256);
        for (Map.Entry<String, Object> item : source.entrySet()) {
            sb.append(item.getKey()).append("=").append(item.getValue()).append("&");
        }

        return sb.toString();
    }

    /**
     * 构建待加密原始字符串
     *
     * @param source
     * @return valvalval
     */
    protected String buildValStr(Map<String, Object> source) {
        StringBuffer sb = new StringBuffer(256);
        for (Map.Entry<String, Object> item : source.entrySet()) {
            sb.append(item.getValue());
        }

        return sb.toString();
    }

    protected String concatSecretKey(String originalStr) {
        StringBuffer sb = new StringBuffer(256);
        sb.append(originalStr).append("key=").append(payData.getSecret_key());
        return sb.toString();
    }

    protected String encrypt(Map<String, Object> source) {
        return Md5Util.md5(concatSecretKey(buildKeyValStr(source)));
    }

    protected String sign(Map<String, Object> source) {
        return encrypt(source);
    }

    protected abstract String pay(PayData param);

    protected abstract String withdraw(Map<String, Object> source);

    protected abstract boolean verifySign(Map<String, Object> source, String signKey);

    protected abstract String payCallBack();

    protected abstract String withdrawCallBack();

    protected abstract Set<String> paySignKeySet();

    protected abstract Set<String> withdrawSignKeySet();

    protected String payResponse() {
        return paySuccessMsg;
    }

    protected String withdrawResponse() {
        return withdrawSuccessMsg;
    }
}
