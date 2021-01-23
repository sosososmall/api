package com.pokerstar.api.domain.entity.admin;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = -9070640341156878036L;

    private int admin_id;

    private String admin_account;

    private String admin_nick_name;

    private String admin_password;

    private boolean admin_status;

    private String admin_phone;

    private int admin_type;

    private String admin_white_ip;

    private int admin_daily_max_login_fail_count;

    private int admin_daily_login_fail_count;

    private int admin_max_confirm_withdraw_count;

    private BigDecimal admin_max_confirm_withdraw_amount;

    private int admin_create_time;

    private String admin_remark;
}
