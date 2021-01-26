package com.pokerstar.api.domain.serviceimpl.agent;

import com.pokerstar.api.domain.dao.agent.IAgentDao;
import com.pokerstar.api.domain.entity.agent.Agent;
import com.pokerstar.api.domain.service.agent.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements IAgentService {
    @Autowired
    private IAgentDao agentDao;

    @Override
    public boolean addAgent(Agent entity) {
        return agentDao.addAgent(entity);
    }

    @Override
    public int deleteAgent(int agentId) {
        return agentDao.deleteAgent(agentId);
    }

    @Override
    public List<Agent> getAllAgent() {
        return agentDao.getAllAgent();
    }

    @Override
    public int updateAgent(Agent param) {
        return agentDao.updateAgent(param);
    }

    @Override
    public int toggleAgentStatus(int agentId, int status) {
        return agentDao.toggleAgentStatus(agentId, status);
    }
}
