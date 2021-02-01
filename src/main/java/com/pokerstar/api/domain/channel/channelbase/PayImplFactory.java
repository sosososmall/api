package com.pokerstar.api.domain.channel.channelbase;

import com.pokerstar.api.domain.model.pay.DepositRequest;
import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayImplFactory {
    private static Logger Log = LoggerFactory.getLogger(PayImplFactory.class);

    /**
     * 获取支付通道实例
     *
     * @param channelShortName
     * @return
     */
    public static AbsPay getInstance(String channelShortName, DepositRequest request) {
        String className = "com.pokerstar.api.domain.channel.channelimpl." + channelShortName + "PayImpl";
        AbsPay payImpl = null;
        try {
            Class<?> clz = Class.forName(className);
            payImpl = (AbsPay) clz.getConstructor(DepositRequest.class).newInstance(request);
        } catch (Exception ex) {
            Log.error("init channel impl error:", ex);
            ex.printStackTrace();
        }

        return payImpl;
    }


    /**
     * 获取支付通道实例
     *
     * @param channelShortName
     * @return
     */
    public static AbsPay getInstance(String channelShortName, WithdrawRequest request) {
        String className = "com.pokerstar.api.domain.channel.channelimpl." + channelShortName + "PayImpl";
        AbsPay payImpl = null;
        try {
            Class<?> clz = Class.forName(className);
            payImpl = (AbsPay) clz.getConstructor(WithdrawRequest.class).newInstance(request);
        } catch (Exception ex) {
            Log.error("init channel impl error:", ex);
            ex.printStackTrace();
        }

        return payImpl;
    }
}
