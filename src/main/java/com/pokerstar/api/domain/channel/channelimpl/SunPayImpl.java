package com.pokerstar.api.domain.channel.channelimpl;

import com.pokerstar.api.domain.channel.channelbase.AbsPay;
import com.pokerstar.api.domain.model.pay.DepositRequest;
import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import com.pokerstar.api.infrastructure.constant.Constant;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import com.pokerstar.api.infrastructure.util.HttpUtil;
import com.pokerstar.api.infrastructure.util.Md5Util;
import com.pokerstar.api.infrastructure.util.StringUtil;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SunPayImpl extends AbsPay {
    /*
    请求 回调皆为 application/json
  */
    public SunPayImpl(DepositRequest request) {
        super(request);
    }

    public SunPayImpl(WithdrawRequest request) {
        super(request);
    }

    public SunPayImpl(HttpServletRequest request, String requestBody) {
        super(request, requestBody);
    }

    @Override
    public String pay() {
        String response = HttpUtil.sendPostJson(depositRequest.getRequest_url(), StringUtil.object2Json(payMap()));
        Map<String, Object> map = StringUtil.json2Map(response);
        return null;
    }

    @Override
    public String withdraw() {
        String result = HttpUtil.sendPostJson(withdrawRequest.getRequest_url(), StringUtil.object2Json(withdrawMap()));
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
    public boolean verifyChannelPaySign() {
        return false;
    }

    @Override
    public boolean verifyChannelWithdrawSign() {
        return false;
    }

    @Override
    protected String sign(String originalStr) {
        return Md5Util.md5(originalStr + getSecret_key());
    }

    @Override
    protected Map<String, Object> withdrawMap() {
        SortedMap<String, Object> result = new TreeMap<>();
        result.put("version", Constant.SUN_PAY_VERSION);
        result.put("signType", Constant.SUN_PAY_SIGN_TYPE);
        result.put("merchantNo", depositRequest.getMerchant_no());
        result.put("date", DateTimeUtil.getCurrentTimeSimpleStr());
        result.put("noticeUrl", depositRequest.getNotify_url());
        result.put("orderNo", depositRequest.getOrder_no());
        result.put("bizAmt", depositRequest.getPay_amount());
        result.put("bankCode", depositRequest.getPay_code());
        result.put("channleType", depositRequest.getPay_code_extra());

        String sign = sign(StringUtil.map2KeyValStr(result));
        result.put("sign", sign);

        return result;
    }

    @Override
    protected Map<String, Object> payMap() {
        SortedMap<String, Object> result = new TreeMap<>();
        result.put("version", Constant.SUN_PAY_VERSION);
        result.put("signType", Constant.SUN_PAY_SIGN_TYPE);
        result.put("merchantNo", withdrawRequest.getMerchant_no());
        result.put("date", DateTimeUtil.getCurrentTimeSimpleStr());
        result.put("channleType", withdrawRequest.getPay_code_extra());
        result.put("orderNo", withdrawRequest.getOrder_no());
        result.put("bizAmt", withdrawRequest.getPay_amount());
        result.put("accName", withdrawRequest.getReal_name());
        result.put("bankCode", withdrawRequest.getPay_code());
        result.put("bankBranchName", withdrawRequest.getBank_branch());
        result.put("cardNo", withdrawRequest.getBank_card());
        result.put("noticeUrl", withdrawRequest.getNotify_url());

        String sign = sign(StringUtil.map2KeyValStr(result));
        result.put("sign", sign);

        return result;
    }

    @Override
    protected String callback_plat_order_no_key() {
        return "orderNo";
    }

    @Override
    protected Map<String, Object> callbackMap() {
        return jsonCallBack2Map();
    }
}
