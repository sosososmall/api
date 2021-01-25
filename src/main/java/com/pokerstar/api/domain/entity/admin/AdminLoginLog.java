package com.pokerstar.api.domain.entity.admin;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminLoginLog implements Serializable {
    private static final long serialVersionUID = -7674534358938212841L;

    private long admin_login_log_id;

    private int admin_id;

    private String admin_account;

    private String admin_nick_name;

    private int admin_type;

    private String admin_login_log_ip;

    private long admin_login_log_time;

    private boolean admin_login_log_status;

    private String admin_login_log_password;
}
