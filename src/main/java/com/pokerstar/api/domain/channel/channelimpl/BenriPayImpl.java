package com.pokerstar.api.domain.channel.channelimpl;

import com.pokerstar.api.domain.channel.channelbase.AbsPay;
import com.pokerstar.api.domain.model.pay.BenriPaySecretKey;
import com.pokerstar.api.domain.model.pay.DepositRequest;
import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import com.pokerstar.api.infrastructure.constant.Constant;
import com.pokerstar.api.infrastructure.util.*;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class BenriPayImpl extends AbsPay {

    public BenriPayImpl(DepositRequest request) {
        super(request);
    }

    public BenriPayImpl(WithdrawRequest request) {
        super(request);
    }

    public BenriPayImpl(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String pay() {
        String response = HttpUtil.sendPostForm(depositRequest.getRequest_url(), StringUtil.map2KeyValStr(payMap()));
        return null;
    }

    @Override
    public String withdraw() {
        String response = HttpUtil.sendPostForm(withdrawRequest.getRequest_url(), StringUtil.map2KeyValStr(withdrawMap()));
        return null;
    }

    @Override
    public String merDepositNotify() {
        return null;
    }

    @Override
    public String merWithdrawNotify() {
        return null;
    }

    @Override
    public String channelDepositCallBack() {
        Map<String, Object> source = HttpServletUtil.body2Map(servletRequest);
        return null;
    }

    @Override
    public String channelWithdrawCallBack() {
        return null;
    }

    @Override
    public boolean verifyChannelPaySign() {
        return false;
    }

    @Override
    public boolean verifyChannelWithdrawSign() {
        return false;
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
            if (item.getValue() != null && StringUtils.isNotBlank(item.getValue().toString())) {
                sb.append(item.getValue());
            }
        }

        return sb.toString();
    }

    @Override
    protected String sign(String originalStr) {
        BenriPaySecretKey secretKey = StringUtil.json2Object(getSecret_key(), BenriPaySecretKey.class);
        return RsaUtil.privateEncrypt(originalStr, RsaUtil.getPrivateKey(secretKey.getMerchant_private_key()));
    }

    @Override
    protected Map<String, Object> withdrawMap() {
        SortedMap<String, Object> result = new TreeMap<>();
        result.put("merchantCode", withdrawRequest.getMerchant_no());
        result.put("orderNum", withdrawRequest.getOrder_no());
        result.put("money", withdrawRequest.getPay_amount());
        result.put("description", "");
        result.put("name", withdrawRequest.getReal_name());
        result.put("bankCode", withdrawRequest.getPay_code());
        result.put("number", withdrawRequest.getBank_card());
        result.put("notifyUrl", withdrawRequest.getNotify_url());
        result.put("feeType", Constant.BENRI_PAY_FEE_TYPE);
        result.put("dateTime", DateTimeUtil.getTimeStr(DateTimeUtil.dateTimeFormatterWithNoJoiner));
        result.put("appId", "");

        String sign = sign(buildValStr(result));
        result.put("sign", sign);

        return result;
    }

    @Override
    protected Map<String, Object> payMap() {
        SortedMap<String, Object> result = new TreeMap<>();
        result.put("dateTime", DateTimeUtil.getTimeStr(DateTimeUtil.dateTimeFormatterWithNoJoiner));
        result.put("merchantCode", depositRequest.getMerchant_no());
        result.put("payMoney", depositRequest.getPay_amount());
        result.put("method", "");
        result.put("productDetail", "");
        result.put("phone", Constant.BENRI_PAY_PHONE);
        result.put("name", Constant.BENRI_PAY_NAME);
        result.put("orderNum", depositRequest.getOrder_no());
        result.put("notifyUrl", depositRequest.getNotify_url());
        result.put("expiryPeriod", Constant.BENRI_PAY_EXPIRY_PERIOD);
        result.put("email", "");
        result.put("appId", "");

        String sign = sign(buildValStr(result));
        result.put("sign", sign);

        return result;
    }

}
