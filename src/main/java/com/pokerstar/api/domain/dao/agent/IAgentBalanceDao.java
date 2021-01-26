package com.pokerstar.api.domain.dao.agent;

import com.pokerstar.api.domain.entity.agent.AgentBalance;

import java.util.List;

public interface IAgentBalanceDao {
    boolean addAgentBalance(AgentBalance entity);

    int deleteAgentBalance(int agentBalanceId);

    List<AgentBalance> getAllAgentBalance();

    int updateAgentBalance(AgentBalance param);
}
