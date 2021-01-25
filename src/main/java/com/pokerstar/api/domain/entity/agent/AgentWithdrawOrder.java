package com.pokerstar.api.domain.entity.agent;

import lombok.Data;

import java.io.Serializable;

@Data
public class AgentWithdrawOrder implements Serializable {
    private static final long serialVersionUID = -5792960722308926920L;

    private long agent_withdraw_order_id;

    private int agent_id;

    private String agent_real_name;

    private String agent_nick_name;

    private String agent_withdraw_order_balance;

    private String agent_withdraw_order_balance_currency_iso_code;

    private long agent_withdraw_order_create_time;

    private int agent_withdraw_order_status;

    private Integer admin_id;

    private String admin_nick_name;

    private Long agent_withdraw_order_operate_time;

    private String agent_withdraw_order_remark;
}
