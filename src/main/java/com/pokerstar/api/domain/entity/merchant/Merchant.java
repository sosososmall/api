package com.pokerstar.api.domain.entity.merchant;

import lombok.Data;

import java.io.Serializable;

@Data
public class Merchant implements Serializable {
    private static final long serialVersionUID = 7056804535918253527L;

    private int merchant_id;

    private int agent_id;

    private String agent_nick_name;

    private String merchant_real_name;

    private String merchant_nick_name;

    private String merchant_account;

    private String merchant_password;

    private String merchant_phone;

    private String merchant_email;

    private String merchant_ip;

    private boolean merchant_status;

    private String merchant_remark;
}
