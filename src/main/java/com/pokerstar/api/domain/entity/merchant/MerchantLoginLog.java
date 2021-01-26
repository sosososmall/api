package com.pokerstar.api.domain.entity.merchant;

import lombok.Data;

import java.io.Serializable;

@Data
public class MerchantLoginLog implements Serializable {
    private static final long serialVersionUID = 7262907677295137184L;

    private long merchant_login_log_id;

    private int merchant_id;

    private String merchant_account;

    private String merchant_login_log_ip;

    private long merchant_login_log_time;

    private boolean merchant_login_log_status;

    private String merchant_login_log_password;
}
