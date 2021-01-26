package com.pokerstar.api.domain.dao.agent;

import com.pokerstar.api.domain.entity.agent.Agent;

import java.util.List;

public interface IAgentDao {
    boolean addAgent(Agent entity);

    int deleteAgent(int agentId);

    List<Agent> getAllAgent();

    int updateAgent(Agent param);

    int toggleAgentStatus(int agentId, int status);
}
