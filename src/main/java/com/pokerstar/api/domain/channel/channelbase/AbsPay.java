package com.pokerstar.api.domain.channel.channelbase;

import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.model.pay.PayData;
import com.pokerstar.api.infrastructure.util.Md5Util;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 支付通道基类
 */
@Data
public abstract class AbsPay {
    private Logger Log = LoggerFactory.getLogger(AbsPay.class);

    protected ChannelMerchant _channelMerchant;

    protected String paySuccessMsg = "success";

    protected String withdrawSuccessMsg = "success";

    private static ConcurrentMap<String, AbsPay> channelMap = new ConcurrentHashMap<>(8);

    private AbsPay() {
    }

    public AbsPay(ChannelMerchant channelMerchant) {
        _channelMerchant = channelMerchant;
    }

    private Object object = new Object();

    /**
     * 获取支付通道实例
     *
     * @param channelMerchant
     * @return
     */
    public static AbsPay getInstance(ChannelMerchant channelMerchant) {
        if (channelMap.containsKey(channelMerchant.getChannel_short_name())) {
            return channelMap.get(channelMerchant.getChannel_short_name());
        }

        String className = "com.pokerstar.api.domain.channel.channelimpl." + channelMerchant.getChannel_short_name() + "PayImpl";

        AbsPay payImpl = null;
        try {
            Class<?> clz = Class.forName(className);
            payImpl = (AbsPay) clz.getConstructor(ChannelMerchant.class).newInstance(channelMerchant);
            channelMap.putIfAbsent(channelMerchant.getChannel_short_name(), payImpl);
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
        sb.append(originalStr).append("key=").append(_channelMerchant.getChannel_merchant_secret_key());
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

    protected String payResponse() {
        return paySuccessMsg;
    }

    protected String defrayResponse() {
        return withdrawSuccessMsg;
    }

}
