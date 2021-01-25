package com.pokerstar.api.domain.entity.agent;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AgentBalance implements Serializable {
    private static final long serialVersionUID = -1162879549968474579L;

    private long agent_balance_id;

    private int agent_id;

    private String agent_balance_currency_iso_code;

    private BigDecimal agent_balance_amount;

    private BigDecimal agent_balance_amount_withdraw;

    private BigDecimal agent_balance_amount_freeze;

    private String agent_balance_remark;
}
