package com.pokerstar.api.domain.model.agent;

import lombok.Data;

import java.io.Serializable;

@Data
public class AgentBank implements Serializable {
    private static final long serialVersionUID = 7765377632988100655L;

    private int admin_id;

    private String agent_bank_code;

    private String agent_bank_card;

    private String agent_bank_branch;
}
