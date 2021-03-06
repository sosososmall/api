package com.pokerstar.api.domain.serviceimpl.agent;

import com.pokerstar.api.domain.dao.agent.IAgentDao;
import com.pokerstar.api.domain.entity.agent.Agent;
import com.pokerstar.api.domain.model.agent.AgentBankBO;
import com.pokerstar.api.domain.service.agent.IAgentService;
import com.pokerstar.api.infrastructure.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements IAgentService {
    private static Logger Log = LoggerFactory.getLogger(AgentServiceImpl.class);

    @Autowired
    private IAgentDao agentDao;

    @Override
    public boolean addAgent(Agent entity) {
        try {
            agentDao.addAgent(entity);

            return true;
        } catch (Exception ex) {
            Log.error("add agent error:", ex);
            return false;
        }
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

    @Override
    public int updateAgentBankInfo(AgentBankBO param) {
        return agentDao.updateAgentBankInfo(param);
    }

    @Override
    public int updateAgentPassword(int agentId, String password) {
        return agentDao.updateAgentPassword(agentId, password);
    }

    @Override
    public int updateAgentWithdrawPassword(int agentId, String withdrawPassword) {
        return agentDao.updateAgentWithdrawPassword(agentId, withdrawPassword);
    }
}
