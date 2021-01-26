package com.pokerstar.api.domain.daoimpl.agent;

import com.pokerstar.api.domain.dao.agent.IAgentLogDao;
import com.pokerstar.api.domain.entity.agent.AgentBalance;
import com.pokerstar.api.domain.entity.agent.AgentBalanceLog;
import com.pokerstar.api.domain.entity.agent.AgentLoginLog;
import com.pokerstar.api.domain.mapper.agent.AgentLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgentLogDaoImpl implements IAgentLogDao {

    @Autowired
    private AgentLogMapper agentLogMapper;

    @Override
    public boolean addAgentLoginLog(AgentLoginLog entity) {
        return agentLogMapper.addAgentLoginLog(entity);
    }

    @Override
    public boolean addAgentBalanceLog(AgentBalanceLog entity) {
        return agentLogMapper.addAgentBalanceLog(entity);
    }

    @Override
    public int deleteAgentLoginLog(long endTimestamp) {
        return agentLogMapper.deleteAgentLoginLog(endTimestamp);
    }

    @Override
    public int deleteAgentBalanceLog(long endTimestamp) {
        return agentLogMapper.deleteAgentBalanceLog(endTimestamp);
    }

    @Override
    public List<AgentLoginLog> getAllAgentLoginLog() {
        return agentLogMapper.getAllAgentLoginLog();
    }

    @Override
    public List<AgentBalanceLog> getAllAgentBalanceLog() {
        return agentLogMapper.getAllAgentBalanceLog();
    }

    @Override
    public int updateAgentBalance(AgentBalance param) {
        return agentLogMapper.updateAgentBalance(param);
    }
}
