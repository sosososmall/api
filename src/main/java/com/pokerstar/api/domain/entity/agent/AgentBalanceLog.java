package com.pokerstar.api.domain.entity.agent;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AgentBalanceLog implements Serializable {
    private static final long serialVersionUID = 3905210111747007890L;

    private long agent_balance_log_id;

    private int agent_id;

    private String agent_real_name;

    private String agent_nick_name;

    private String agent_balance_log_currency_iso_code;

    private BigDecimal agent_balance_log_balance_before;

    private BigDecimal agent_balance_log_balance_after;

    private BigDecimal agent_balance_log_balance;

    private String agent_balance_log_balance_source;

    private long agent_balance_log_create_time;

    private int balance_change_type_id;

    private String agent_balance_log_remark;
}
