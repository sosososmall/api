package com.pokerstar.api.domain.service.agent;

import com.pokerstar.api.domain.entity.agent.Agent;
import com.pokerstar.api.domain.model.agent.AgentBank;

import java.util.List;

public interface IAgentService {
    boolean addAgent(Agent entity);

    int deleteAgent(int agentId);

    List<Agent> getAllAgent();

    int updateAgent(Agent param);

    int toggleAgentStatus(int agentId, int status);

    int updateAgentBankInfo(AgentBank param);

    int updateAgentPassword(int agentId, String password);

    int updateAgentWithdrawPassword(int agentId, String withdrawPassword);
}