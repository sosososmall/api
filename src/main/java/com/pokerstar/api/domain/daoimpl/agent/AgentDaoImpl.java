package com.pokerstar.api.domain.daoimpl.agent;

import com.pokerstar.api.domain.dao.agent.IAgentDao;
import com.pokerstar.api.domain.entity.agent.Agent;
import com.pokerstar.api.domain.mapper.agent.AgentMapper;
import com.pokerstar.api.domain.model.agent.AgentBankBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgentDaoImpl implements IAgentDao {

    @Autowired
    private AgentMapper agentMapper;


    @Override
    public boolean addAgent(Agent entity) {
        return agentMapper.addAgent(entity);
    }

    @Override
    public int deleteAgent(int agentId) {
        return agentMapper.deleteAgent(agentId);
    }

    @Override
    public List<Agent> getAllAgent() {
        return agentMapper.getAllAgent();
    }

    @Override
    public int updateAgent(Agent param) {
        return agentMapper.updateAgent(param);
    }

    @Override
    public int toggleAgentStatus(int agentId, int status) {
        return agentMapper.toggleAgentStatus(agentId, status);
    }

    @Override
    public int updateAgentBankInfo(AgentBankBO param) {
        return agentMapper.updateAgentBankInfo(param);
    }

    @Override
    public int updateAgentPassword(int agentId, String password) {
        return agentMapper.updateAgentPassword(agentId, password);
    }

    @Override
    public int updateAgentWithdrawPassword(int agentId, String withdrawPassword) {
        return agentMapper.updateAgentWithdrawPassword(agentId, withdrawPassword);
    }
}
