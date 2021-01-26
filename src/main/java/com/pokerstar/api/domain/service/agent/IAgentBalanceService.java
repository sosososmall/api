package com.pokerstar.api.domain.service.agent;

import com.pokerstar.api.domain.entity.agent.AgentBalance;

import java.util.List;

public interface IAgentBalanceService {
    boolean addAgentBalance(AgentBalance entity);

    int deleteAgentBalance(int agentBalanceId);

    List<AgentBalance> getAllAgentBalance();

    int updateAgentBalance(AgentBalance param);
}
