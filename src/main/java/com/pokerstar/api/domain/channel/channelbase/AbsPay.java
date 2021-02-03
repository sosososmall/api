package com.pokerstar.api.domain.channel.channelbase;

import com.pokerstar.api.domain.model.pay.DepositRequest;
import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import com.pokerstar.api.infrastructure.util.StringUtil;
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

    protected String requestBody;

    protected HttpServletRequest servletRequest;

    protected String paySuccessMsg = "success";

    protected String withdrawSuccessMsg = "success";

    protected String sign_key = "sign";

    protected String callback_sign_key = "sign";

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

    public AbsPay(HttpServletRequest request, String requestBody) {
        this.servletRequest = request;
        this.requestBody = requestBody;
    }

    public static BigDecimal calcFee(BigDecimal amount, int deductAmount, BigDecimal rate) {
        return amount.multiply(rate).divide(BigDecimal.valueOf(100)).
                add(BigDecimal.valueOf(deductAmount)).
                setScale(2, BigDecimal.ROUND_UP);
    }

    public boolean verifyMerPaySign(String merSign) {
        return payMap().get(sign_key).equals(merSign);
    }

    public boolean verifyMerWithdrawSign(String merSign) {
        return withdrawMap().get(sign_key).equals(merSign);
    }

    protected Map<String, Object> jsonCallBack2Map() {
        return StringUtil.json2Map(requestBody);
    }

    protected Map<String, Object> formCallBack2Map() {
        return StringUtil.queryString2Map(requestBody);
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

    protected abstract String callback_plat_order_no_key();

    protected abstract Map<String, Object> callbackMap();
}
