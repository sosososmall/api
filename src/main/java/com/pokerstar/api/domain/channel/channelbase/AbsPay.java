package com.pokerstar.api.domain.channel.channelbase;

import com.pokerstar.api.domain.model.pay.DepositRequest;
import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    protected String paySuccessMsg = "success";

    protected String withdrawSuccessMsg = "success";

    protected String secret_key;

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

    public static BigDecimal calcFee(BigDecimal amount, int deductAmount, BigDecimal rate) {
        return amount.multiply(rate).divide(BigDecimal.valueOf(100)).
                add(BigDecimal.valueOf(deductAmount)).
                setScale(2, BigDecimal.ROUND_UP);
    }

    public abstract String pay();

    public abstract String withdraw();

    public abstract boolean verifySign();

    public abstract boolean verifyPaySign();

    public abstract boolean verifyWithdrawSign();

    protected abstract String sign(String originalStr);

    protected abstract Map<String, Object> withdrawMap();

    protected abstract Map<String, Object> payMap();

    protected abstract String payCallBack();

    protected abstract String withdrawCallBack();
}
