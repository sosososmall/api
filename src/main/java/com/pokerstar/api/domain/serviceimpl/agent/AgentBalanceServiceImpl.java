package com.pokerstar.api.domain.serviceimpl.agent;

import com.pokerstar.api.domain.dao.agent.IAgentBalanceDao;
import com.pokerstar.api.domain.entity.agent.AgentBalance;
import com.pokerstar.api.domain.service.agent.IAgentBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentBalanceServiceImpl implements IAgentBalanceService {
    @Autowired
    private IAgentBalanceDao agentBalanceDao;

    @Override
    public boolean addAgentBalance(AgentBalance entity) {
        return agentBalanceDao.addAgentBalance(entity);
    }

    @Override
    public int deleteAgentBalance(int agentBalanceId) {
        return agentBalanceDao.deleteAgentBalance(agentBalanceId);
    }

    @Override
    public List<AgentBalance> getAllAgentBalance() {
        return agentBalanceDao.getAllAgentBalance();
    }

    @Override
    public int updateAgentBalance(AgentBalance param) {
        return agentBalanceDao.updateAgentBalance(param);
    }
}
