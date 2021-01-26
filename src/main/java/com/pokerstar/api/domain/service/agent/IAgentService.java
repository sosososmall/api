package com.pokerstar.api.domain.service.agent;

import com.pokerstar.api.domain.entity.agent.Agent;
import com.pokerstar.api.domain.entity.agent.AgentBalance;
import com.pokerstar.api.domain.entity.agent.AgentBalanceLog;
import com.pokerstar.api.domain.entity.agent.AgentLoginLog;

import java.util.List;

public interface IAgentService {
    boolean addAgent(Agent entity);

    int deleteAgent(int agentId);

    List<Agent> getAllAgent();

    int updateAgent(Agent param);

    int toggleAgentStatus(int agentId, int status);
}
