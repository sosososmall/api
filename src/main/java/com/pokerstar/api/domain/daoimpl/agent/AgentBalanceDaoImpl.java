package com.pokerstar.api.domain.daoimpl.agent;

import com.pokerstar.api.domain.dao.agent.IAgentBalanceDao;
import com.pokerstar.api.domain.entity.agent.AgentBalance;
import com.pokerstar.api.domain.mapper.agent.AgentBalanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgentBalanceDaoImpl implements IAgentBalanceDao {

    @Autowired
    private AgentBalanceMapper agentBalanceMapper;

    @Override
    public boolean addAgentBalance(AgentBalance entity) {
        return agentBalanceMapper.addAgentBalance(entity);
    }

    @Override
    public int deleteAgentBalance(int agentBalanceId) {
        return agentBalanceMapper.deleteAgentBalance(agentBalanceId);
    }

    @Override
    public List<AgentBalance> getAllAgentBalance() {
        return agentBalanceMapper.getAllAgentBalance();
    }

    @Override
    public int updateAgentBalance(AgentBalance param) {
        return agentBalanceMapper.updateAgentBalance(param);
    }
}
