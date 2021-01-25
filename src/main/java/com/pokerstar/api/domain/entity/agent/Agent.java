package com.pokerstar.api.domain.entity.agent;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Agent implements Serializable {
    private static final long serialVersionUID = 3793342171256119834L;

    private int agent_id;

    private String agent_real_name;

    private String agent_nick_name;

    private String agent_account;

    private String agent_phone;

    private String agent_password;

    private String agent_withdraw_password;

    private boolean agent_status;

    private long agent_create_time;

    private String agent_white_ip;

    private Integer agent_belong;

    private BigDecimal agent_contribution_ratio;

    private Integer agent_daily_max_login_fail_count;

    private Integer agent_daily_login_fail_count;

    private String agent_remark;
}
