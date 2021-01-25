package com.pokerstar.api.domain.entity.agent;

import lombok.Data;

import java.io.Serializable;

@Data
public class AgentLoginLog implements Serializable {
    private static final long serialVersionUID = 2189777262678445243L;

    private long agent_login_log_id;

    private int agent_id;

    private String agent_account;

    private String agent_nick_name;

    private String agent_login_log_ip;

    private long agent_login_log_time;

    private String agent_login_log_remark;

}
