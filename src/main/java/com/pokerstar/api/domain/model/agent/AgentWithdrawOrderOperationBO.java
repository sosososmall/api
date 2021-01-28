package com.pokerstar.api.domain.model.agent;

import lombok.Data;

import java.io.Serializable;

@Data
public class AgentWithdrawOrderOperationBO implements Serializable {
    private static final long serialVersionUID = -3249543307627752974L;

    private long agent_withdraw_order_id;

    private int agent_withdraw_order_status;

    private int admin_id;

    private String admin_nick_name;

    private long agent_withdraw_order_operate_time;

    private String agent_withdraw_order_remark;
}
