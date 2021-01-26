package com.pokerstar.api.domain.serviceimpl.agent;

import com.pokerstar.api.domain.dao.agent.IAgentLogDao;
import com.pokerstar.api.domain.entity.agent.AgentBalance;
import com.pokerstar.api.domain.entity.agent.AgentBalanceLog;
import com.pokerstar.api.domain.entity.agent.AgentLoginLog;
import com.pokerstar.api.domain.service.agent.IAgentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentLogServiceImpl implements IAgentLogService {
    @Autowired
    private IAgentLogDao agentLogDao;


    @Override
    public boolean addAgentLoginLog(AgentLoginLog entity) {
        return agentLogDao.addAgentLoginLog(entity);
    }

    @Override
    public boolean addAgentBalanceLog(AgentBalanceLog entity) {
        return agentLogDao.addAgentBalanceLog(entity);
    }

    @Override
    public int deleteAgentLoginLog(long endTimestamp) {
        return agentLogDao.deleteAgentLoginLog(endTimestamp);
    }

    @Override
    public int deleteAgentBalanceLog(long endTimestamp) {
        return agentLogDao.deleteAgentBalanceLog(endTimestamp);
    }

    @Override
    public List<AgentLoginLog> getAllAgentLoginLog() {
        return agentLogDao.getAllAgentLoginLog();
    }

    @Override
    public List<AgentBalanceLog> getAllAgentBalanceLog() {
        return agentLogDao.getAllAgentBalanceLog();
    }

    @Override
    public int updateAgentBalance(AgentBalance param) {
        return agentLogDao.updateAgentBalance(param);
    }
}
