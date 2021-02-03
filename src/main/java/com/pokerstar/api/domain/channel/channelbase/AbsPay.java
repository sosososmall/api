package com.pokerstar.api.domain.channel.channelbase;

import com.pokerstar.api.domain.model.pay.DepositRequest;
import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 支付通道基类
 */
@Data
public abstract class AbsPay {
    private static Logger Log = LoggerFactory.getLogger(AbsPay.class);

    protected DepositRequest depositRequest;

    protected WithdrawRequest withdrawRequest;

    protected String secret_key;

    protected String paySuccessMsg = "success";

    protected String withdrawSuccessMsg = "success";

    protected String sign_key = "sign";

    protected HttpServletRequest servletRequest;

    private AbsPay() {
    }

    public AbsPay(DepositRequest request) {
        this.depositRequest = request;
        this.secret_key = request.getSecret_key();
    }

    public AbsPay(WithdrawRequest request) {
        this.withdrawRequest = request;
        this.secret_key = request.getSecret_key();
    }

    public AbsPay(HttpServletRequest request) {
        this.servletRequest = request;
    }

    public static BigDecimal calcFee(BigDecimal amount, int deductAmount, BigDecimal rate) {
        return amount.multiply(rate).divide(BigDecimal.valueOf(100)).
                add(BigDecimal.valueOf(deductAmount)).
                setScale(2, BigDecimal.ROUND_UP);
    }

    public boolean verifyMerPaySign(String merSign) {
        //todo
        return payMap().get(sign_key).equals(merSign);
    }

    public boolean verifyMerWithdrawSign(String merSign) {
        //todo
        return withdrawMap().get(sign_key).equals(merSign);
    }

    public abstract String pay();

    public abstract String withdraw();

    public abstract String merDepositNotify();

    public abstract String merWithdrawNotify();

    public abstract String channelDepositCallBack();

    public abstract String channelWithdrawCallBack();

    public abstract boolean verifyChannelPaySign();

    public abstract boolean verifyChannelWithdrawSign();

    protected abstract String sign(String originalStr);

    protected abstract Map<String, Object> withdrawMap();

    protected abstract Map<String, Object> payMap();
}
