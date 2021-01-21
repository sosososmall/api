package com.pokerstar.api.domain.entity.admin;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = -9070640341156878036L;

    private int admin_id;

    private String admin_account;

    private String admin_password;

    private boolean admin_status;

    private int admin_type;

    private int admin_create_time;

    private String admin_white_ip;

    private String admin_remark;
}
