package com.pokerstar.api.domain.entity.admin;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminLog implements Serializable {
    private static final long serialVersionUID = -4152754344465527751L;

    private long admin_log_id;

    private int admin_id;

    private String admin_nick_name;

    private int admin_type;

    private String admin_log_operate_method;

    private int admin_log_operate_time;

    private String admin_log_operate;

    private String admin_log_remark;
}
