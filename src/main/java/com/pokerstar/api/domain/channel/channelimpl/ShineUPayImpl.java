package com.pokerstar.api.domain.channel.channelimpl;

import com.pokerstar.api.domain.channel.channelbase.AbsPay;
import com.pokerstar.api.domain.model.pay.DepositRequest;

import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import com.pokerstar.api.infrastructure.constant.Constant;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import com.pokerstar.api.infrastructure.util.HttpUtil;
import com.pokerstar.api.infrastructure.util.Md5Util;
import com.pokerstar.api.infrastructure.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class ShineUPayImpl extends AbsPay {
    /*
    请求 回调皆为 application/json
     */

    private static Logger Log = LoggerFactory.getLogger(ShineUPayImpl.class);

    public ShineUPayImpl(DepositRequest request) {
        super(request);
    }

    public ShineUPayImpl(WithdrawRequest request) {
        super(request);
    }

    public ShineUPayImpl(HttpServletRequest request, String requestBody) {
        super(request, requestBody);
    }

    private String doRequest(String url, String param) {
        Map<String, Object> header = new HashMap<>(1);
        String sign = sign(param);
        header.put("Api-Sign", sign);
        try {
            return HttpUtil.sendPostJson(depositRequest.getRequest_url(), param, header);
        } catch (Exception ex) {
            Log.error("ShineUPayImpl request error:url = " + url + ",content=" + param, ex);
            return null;
        }
    }

    @Override
    public String pay() {
        String originalStr = StringUtil.object2Json(payMap());
        String result = doRequest(depositRequest.getRequest_url(), originalStr);
        return null;
    }

    @Override
    public String withdraw() {
        String originalStr = StringUtil.object2Json(payMap());
        String result = doRequest(withdrawRequest.getRequest_url(), originalStr);
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
        return null;
    }

    @Override
    public String channelWithdrawCallBack() {
        return null;
    }

    @Override
    public boolean verifyMerPaySign(String merSign) {
        return sign(StringUtil.object2Json(payMap())).equals(merSign);
    }

    @Override
    public boolean verifyMerWithdrawSign(String merSign) {
        return sign(StringUtil.object2Json(withdrawMap())).equals(merSign);
    }

    @Override
    public boolean verifyChannelPaySign() {
        return false;
    }

    @Override
    public boolean verifyChannelWithdrawSign() {
        return false;
    }

    @Override
    protected String sign(String originalStr) {
        return Md5Util.md5(originalStr + "|" + getSecret_key().split("|")[0]);
    }

    @Override
    protected Map<String, Object> withdrawMap() {
        Map<String, Object> bodyMap = new HashMap<>(20);
        bodyMap.put("AdvPasswordMd5", getSecret_key().split("|")[1]);
        bodyMap.put("OrderId", withdrawRequest.getOrder_no());
        bodyMap.put("Flag", Constant.SHINEU_WITHDRAW_FLAG);
        bodyMap.put("BankCode", withdrawRequest.getBank_card());
        bodyMap.put("BankUser", withdrawRequest.getReal_name());
        bodyMap.put("BankUserPhone", withdrawRequest.getPhone_no());
        bodyMap.put("BankProvinceName", "");
        bodyMap.put("BankCityName", "");
        bodyMap.put("BankAddress", withdrawRequest.getBank_branch());
        bodyMap.put("BankUserEmail", Constant.SHINEU_WITHDRAW_EMAIL);
        bodyMap.put("BankUserIFSC", withdrawRequest.getPay_code());
        bodyMap.put("Amount", withdrawRequest.getPay_amount());
        bodyMap.put("RealAmount", withdrawRequest.getPay_amount());
        bodyMap.put("Details", "");
        bodyMap.put("NotifyUrl", withdrawRequest.getNotify_url());
        bodyMap.put("Extend1", "");
        bodyMap.put("Extend2", "");
        bodyMap.put("Extend3", "");
        bodyMap.put("Extend4", "");
        bodyMap.put("Extend5", "");

        Map<String, Object> result = new HashMap<>(3);
        result.put("Body", bodyMap);
        result.put("MerchantId", depositRequest.getMerchant_no());
        result.put("Timestamp", DateTimeUtil.getCurrentMillSecondTimestamp());

        return bodyMap;
    }

    @Override
    protected Map<String, Object> payMap() {
        Map<String, Object> bodyMap = new HashMap<>(13);
        bodyMap.put("PayTypeId", "");
        bodyMap.put("Amount", depositRequest.getPay_amount());
        bodyMap.put("OrderId", depositRequest.getOrder_no());
        bodyMap.put("Details", "pay");
        bodyMap.put("UserId", "");
        bodyMap.put("IsVip", false);
        bodyMap.put("NotifyUrl", depositRequest.getNotify_url());
        bodyMap.put("RedirectUrl", "");
        bodyMap.put("Extend1", "");
        bodyMap.put("Extend2", "");
        bodyMap.put("Extend3", "");
        bodyMap.put("Extend4", "");
        bodyMap.put("Extend5", "");

        Map<String, Object> result = new HashMap<>(3);
        result.put("Body", bodyMap);
        result.put("MerchantId", depositRequest.getMerchant_no());
        result.put("Timestamp", DateTimeUtil.getCurrentMillSecondTimestamp());

        return result;
    }

    @Override
    protected String callback_plat_order_no_key() {
        return "platformOrderId";
    }


    @Override
    protected Map<String, Object> callbackMap() {
        /**
         *
         *
         * callback request body :
         * {
         *   "merchantId": "A6205J1AJL6O8942",
         *   "timestamp": "1612029799815",
         *   "body": {
         *     "orderId": "4408184592159277057",
         *     "platformOrderId": "20210130AARJ38X3EVWG8473",
         *     "status": 1,
         *     "message": null,
         *     "amount": 18.0000
         *   }
         * }
         */
        return jsonCallBack2Map();
    }
}
